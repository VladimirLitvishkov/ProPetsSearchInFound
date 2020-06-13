package propets.model.searchinfound;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
@Document(indexName = "foundtosearch")
public class FoundToSearch {
	
	@Id
	String id;
	String userLogin;
	String type;
	String breed;
	String sex;
	Address address;
	@GeoPointField
	Coordinates coordinates;
	String tags;

}
