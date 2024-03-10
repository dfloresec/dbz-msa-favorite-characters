package ec.com.favorite.characters.repository;

import java.util.List;

import ec.com.favorite.characters.service.dto.characters.GaleryDto;
import feign.RequestLine;

public interface CharactersClient {

	@RequestLine("GET /characters")
	public List<GaleryDto> getCharacters();

}