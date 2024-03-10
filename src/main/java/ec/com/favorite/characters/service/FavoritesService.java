package ec.com.favorite.characters.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.favorite.characters.domain.FavoritesEntity;
import ec.com.favorite.characters.domain.FavoritesIdEntity;
import ec.com.favorite.characters.repository.FavoritesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoritesService {

	private final FavoritesRepository favoritesRepository;

	public void save(String usermane, Integer id, boolean active) {
		FavoritesIdEntity favoritesIdEntity = new FavoritesIdEntity();
		favoritesIdEntity.setUsermane(usermane);
		favoritesIdEntity.setId(id);

		FavoritesEntity entity = new FavoritesEntity();
		entity.setId(favoritesIdEntity);
		entity.setState(active ? "ACT" : "INA");

		favoritesRepository.save(entity);
	}

	public List<FavoritesEntity> findAllStateACT(String usermane) {
		return favoritesRepository.findAllStateACT(usermane);
	}

}
