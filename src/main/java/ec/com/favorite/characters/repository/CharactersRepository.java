package ec.com.favorite.characters.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ec.com.favorite.characters.service.dto.characters.GaleryDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Repository
public class CharactersRepository {
	
	public List<GaleryDto> getCharacters() {
		CharactersClient client = Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(CharactersClient.class, "http://localhost:8081");
		return client.getCharacters();
	}

	
	
}
