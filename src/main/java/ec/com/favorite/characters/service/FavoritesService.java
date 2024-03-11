package ec.com.favorite.characters.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ec.com.favorite.characters.domain.FavoritesEntity;
import ec.com.favorite.characters.domain.FavoritesIdEntity;
import ec.com.favorite.characters.repository.FavoritesRepository;
import ec.com.favorite.characters.service.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoritesService {

	private final FavoritesRepository favoritesRepository;

	public void createOrUpdate(RequestDto req) {
		FavoritesIdEntity favoritesIdEntity = new FavoritesIdEntity();
		favoritesIdEntity.setUsermane(req.getUser());
		favoritesIdEntity.setId(req.getId());

		Optional<FavoritesEntity> entityExist = favoritesRepository.findById(favoritesIdEntity);
		if (entityExist.isPresent()) {
			entityExist.get().setState(entityExist.get().getState().equals("ACT") ? "INA" : "ACT");
			favoritesRepository.save(entityExist.get());
			log.info("Cambio a estado " + entityExist.get().getState());
		} else {
			FavoritesEntity entityNew = new FavoritesEntity();
			entityNew.setId(favoritesIdEntity);
			entityNew.setState("ACT");
			favoritesRepository.save(entityNew);
			log.info("No existia y se creo con estado a ACT");
		}

	}

	public List<Integer> findAllStateACT(String usermane) {
		List<FavoritesEntity> list = favoritesRepository.findAllStateACT(usermane);
		return list.stream().map(elemento -> elemento.getId().getId()).collect(Collectors.toList());
	}

}
