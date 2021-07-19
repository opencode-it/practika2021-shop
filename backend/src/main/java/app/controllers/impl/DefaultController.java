package app.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Контроллер с приветствем :3
 * @author Krll
 *
 * */
@RestController
@RequestMapping
public class DefaultController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    Map oauth2AuthenticationUrls = new HashMap();
    private static String authorizationRequestBaseUri
            = "oauth2/authorization";
    @GetMapping("/")
    public String main(HttpServletResponse response) throws IOException {
        response.sendRedirect("/suc");
        return "Welcome to Spring Boot server";
    }
    @GetMapping("/suc")
    public String succes(){
        Iterable clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable) clientRegistrationRepository;
        }

        return "suc";
    }
}
