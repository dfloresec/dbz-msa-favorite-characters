package ec.com.favorite.characters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.favorite.characters.domain.FavoritesEntity;
import ec.com.favorite.characters.domain.FavoritesIdEntity;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, FavoritesIdEntity> {

	List<FavoritesEntity> findAllStateACT(String usermane);

}
