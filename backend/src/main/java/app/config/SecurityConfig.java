package app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

/**
 * Класс конфигурации для Oauth2 авторизации
 * @author Krll
 *
 * */
@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.yml")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Value("${spring.security.oauth2.client.registration.google.clientId}")
        String clientId;
        @Value("${spring.security.oauth2.client.registration.google.clientSecret}")
        String clientSecret;



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated()
                    .and()
                    .oauth2Login()
                    .clientRegistrationRepository(clientRegistrationRepository())
                    .authorizedClientService(authorizedClientService());
        }
        @Bean
        public OAuth2AuthorizedClientService authorizedClientService() {

                    return new InMemoryOAuth2AuthorizedClientService(
                    clientRegistrationRepository());
        }
        @Bean
        public ClientRegistrationRepository clientRegistrationRepository() {

            ClientRegistration registrations = CommonOAuth2Provider.GOOGLE.getBuilder("google")
                    .clientId("35541507052-oh08hc1v6alfibvudf2nt6q30119pise.apps.googleusercontent.com").clientSecret("3yq3zm1rFH0ALs3t7dfrQtkG").build();
            return new InMemoryClientRegistrationRepository(registrations);

        }
}