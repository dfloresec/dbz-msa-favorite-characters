package ec.com.favorite.characters.service.dto.characters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GaleryDto {

	private Integer id;

	private String name;

	private String gender;

	private String ki;

	private String image;

}
