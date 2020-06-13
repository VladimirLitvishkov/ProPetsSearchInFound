package propets.dto.searchinfound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import propets.model.searchinfound.Address;
import propets.model.searchinfound.Coordinates;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
public class LostFoundToSearchDTO {

	String id;
	String userLogin;
	String type;
	String breed;
	String sex;
	Address address;
	Coordinates coordinates;
	String tags;

}
