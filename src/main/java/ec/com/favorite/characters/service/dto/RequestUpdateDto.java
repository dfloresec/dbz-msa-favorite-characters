package ec.com.favorite.characters.service.dto;

import lombok.Data;

@Data
public class RequestUpdateDto {

	private Integer id;
	
	private String user;
	
	private boolean active;
	
}
