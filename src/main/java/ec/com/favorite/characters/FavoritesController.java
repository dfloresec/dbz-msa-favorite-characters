package ec.com.favorite.characters;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.favorite.characters.domain.FavoritesEntity;
import ec.com.favorite.characters.service.FavoritesService;
import ec.com.favorite.characters.service.dto.RequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FavoritesController {

	private final FavoritesService favoritesService;

	@PostMapping(value = "/favoritec")
	@ResponseStatus(HttpStatus.CREATED)
	private void create(@RequestBody RequestDto req) {
		favoritesService.save(req.getUser(), req.getId(), true);
	}
	
	@PatchMapping(value = "/favoriteu")
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody RequestDto req) {
		favoritesService.save(req.getUser(), req.getId(), false);
	}

	@GetMapping(value = "/favorites/{user}")
	@ResponseStatus(HttpStatus.OK)
	private List<FavoritesEntity> create(@PathVariable(name = "user") String user) {
		return favoritesService.findAllStateACT(user);
	}

}
