package ec.com.favorite.characters.domain;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "FAVORITES")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "FavoritesEntity.findAllStateACT",
query = "select u from FavoritesEntity u where u.id.usermane = ?1 and u.state = 'ACT'")
public class FavoritesEntity {

	@EmbeddedId
	FavoritesIdEntity id;

	String state;

}
