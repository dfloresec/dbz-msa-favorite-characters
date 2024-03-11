package ec.com.favorite.characters.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ec.com.favorite.characters.repository.CharactersRepository;
import ec.com.favorite.characters.service.dto.characters.GaleryDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharactersService {

	private final FavoritesService favoritesService;

	private final CharactersRepository charactersRepository;

	public List<GaleryDto> getFavorities(String usermane) {
		List<Integer> idsFavorities = favoritesService.findAllStateACT(usermane);
		if (idsFavorities.isEmpty()) {
			throw new EntityNotFoundException("No tiene favoritos");
		}
		try {
			List<GaleryDto> all = charactersRepository.getCharacters();

			List<GaleryDto> result = all.stream()
					.filter(itemAll -> idsFavorities.stream().anyMatch(itemFav -> itemFav.equals(itemAll.getId())))
					.collect(Collectors.toList());
			log.info(result.size() + " favoritos obtenidos.");
			return result;
		} catch (Exception e) {
			log.error("Error", e);
			return null;
		}
	}

}
