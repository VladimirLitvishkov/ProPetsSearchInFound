package propets.configuration.searchinfound;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@RefreshScope
@Getter
public class SearchInFoundConfiguration {
	
	@Value("${percentToSearch}")
	Integer percentToSearch;
	
	@Value("${radiusSearch}")
	Integer radiusSearch;
	
	@Value("${keyUsers}")
	String keyUsers;

	@Value("${keyPosts}")
	String keyPosts;

	
}
