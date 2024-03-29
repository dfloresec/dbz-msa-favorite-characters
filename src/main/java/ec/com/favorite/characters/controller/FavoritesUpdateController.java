package ec.com.favorite.characters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.favorite.characters.service.FavoritesService;
import ec.com.favorite.characters.service.dto.RequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FavoritesUpdateController {

	private final FavoritesService favoritesService;

	@PostMapping(path = "/favorite", produces = { "*/*;*" }, consumes = { "*/*;*" })
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody RequestDto req) {
		favoritesService.createOrUpdate(req);
	}

}
