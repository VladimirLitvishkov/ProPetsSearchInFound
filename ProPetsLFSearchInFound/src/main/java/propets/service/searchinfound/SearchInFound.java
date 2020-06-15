package propets.service.searchinfound;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import propets.configuration.searchinfound.SearchInFoundConfiguration;
import propets.dao.searchinfound.FoundToSearchRepository;
import propets.dto.searchinfound.LostFoundToSearchDTO;
import propets.model.searchinfound.FoundToSearch;

@EnableBinding(Processor.class)
public class SearchInFound {

	@Autowired
	FoundToSearchRepository foundRepository;

	@Autowired
	SearchInFoundConfiguration configuration;

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Map<String, Set<String>> searchForMatches(LostFoundToSearchDTO lostFoundToSearch) {
		Set<FoundToSearch> resultSearchFromBD = foundRepository.findPosts(lostFoundToSearch.getType(),
				lostFoundToSearch.getBreed(), lostFoundToSearch.getSex(),
				lostFoundToSearch.getCoordinates().getLat(),
				lostFoundToSearch.getCoordinates().getLon(), configuration.getRadiusSearch(),
				lostFoundToSearch.getTags(), configuration.getPercentToSearch());
		if (resultSearchFromBD != null) {
			Map<String, Set<String>> result = new HashMap<>();
			Set<String> user = new HashSet<>();
			user.add(lostFoundToSearch.getUserLogin());
			result.put(configuration.getKeyUsers(), user);
			result.put(configuration.getKeyPosts(),
					resultSearchFromBD.stream().map(p -> p.getId()).collect(Collectors.toSet()));
			return result;
		}
		return null;
	}

}
