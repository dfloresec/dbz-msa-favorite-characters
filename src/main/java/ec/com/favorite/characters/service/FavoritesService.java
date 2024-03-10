package ec.com.favorite.characters.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ec.com.favorite.characters.domain.FavoritesEntity;
import ec.com.favorite.characters.domain.FavoritesIdEntity;
import ec.com.favorite.characters.repository.FavoritesRepository;
import ec.com.favorite.characters.service.dto.RequestUpdateDto;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoritesService {

	private final FavoritesRepository favoritesRepository;

	public void save(String usermane, Integer id) {
		FavoritesIdEntity favoritesIdEntity = new FavoritesIdEntity();
		favoritesIdEntity.setUsermane(usermane);
		favoritesIdEntity.setId(id);

		if (favoritesRepository.existsById(favoritesIdEntity)) {
			throw new EntityExistsException("Ya existe");
		}

		FavoritesEntity entity = new FavoritesEntity();
		entity.setId(favoritesIdEntity);
		entity.setState("ACT");

		favoritesRepository.save(entity);
	}

	public void update(RequestUpdateDto req) {
		FavoritesIdEntity favoritesIdEntity = new FavoritesIdEntity();
		favoritesIdEntity.setUsermane(req.getUser());
		favoritesIdEntity.setId(req.getId());

		FavoritesEntity entity = favoritesRepository.getReferenceById(favoritesIdEntity);
		entity.setState(req.isActive() ? "ACT" : "INA");
		favoritesRepository.save(entity);
	}

	public List<Integer> findAllStateACT(String usermane) {
		List<FavoritesEntity> list = favoritesRepository.findAllStateACT(usermane);
		return list.stream().map(elemento -> elemento.getId().getId()).collect(Collectors.toList());
	}

}
