package guru.springframework;

import guru.springframework.ck.v3.api.ConvertKitApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConvertKitApiConfig.class)
public class SpringConvertKitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConvertKitApplication.class, args);
	}
}
