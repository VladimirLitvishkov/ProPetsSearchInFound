package propets.dao.searchinfound;

import java.util.Set;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import propets.model.searchinfound.FoundToSearch;

public interface FoundToSearchRepository extends ElasticsearchRepository<FoundToSearch, String> {

	@Query("{\'bool\':{\'must\':[{\'match\':{\'type\':\'?0\'}},{\'match\':{\'breed\':\'?1\'}},{\'match\':{\'sex\':\'?2\'}},{\'match\':{\'tags\':{\'query\':\'?6\',\'minimum_should_match\':\'?7%\'}}}],\'filter\':{\'geo_distance\':{\'distance\':\'?5km\',\'coordinates\':{\'lat\':\'?3\',\'lon\':\'?4\'}}}}}")
	Set<FoundToSearch> findPosts(String type, String breed, String sex, Double lat, Double lon, int radius,
			String tags, int minPercent);

}
