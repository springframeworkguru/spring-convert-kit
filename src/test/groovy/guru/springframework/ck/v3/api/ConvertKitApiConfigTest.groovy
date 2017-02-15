package guru.springframework.ck.v3.api

import guru.springframework.SpringConvertKitApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

/**
 * Created by jt on 11/16/16.
 */
@ContextConfiguration(classes = ConvertKitApiConfigTest.TestConfig)
@TestPropertySource(locations = "classpath:application.properties")
class ConvertKitApiConfigTest extends Specification{

    @Configuration
    @EnableConfigurationProperties(ConvertKitApiConfig.class)
    @ComponentScan(basePackages = "uru.springframework.ck.v3.api")
    public static class TestConfig{

    }

    @Autowired
    ConvertKitApiConfig config

    def "Test Config Props"() {
        when:

        def foo = 1

        then:
        config.ckApiKey
        config.ckApiSecret
    }
}
