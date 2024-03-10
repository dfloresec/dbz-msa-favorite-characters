package ec.com.favorite.characters.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class FavoritesIdEntity {

	Integer id;

	String usermane;

}
