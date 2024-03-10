package ec.com.favorite.characters.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.favorite.characters.service.CharactersService;
import ec.com.favorite.characters.service.dto.characters.GaleryDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FavoritesListController {

	private final CharactersService charactersService;

	@GetMapping(value = "/favorites/{user}")
	@ResponseStatus(HttpStatus.OK)
	private List<GaleryDto> getFavorities(@PathVariable(name = "user") String user) {
		return charactersService.getFavorities(user);
	}

}
