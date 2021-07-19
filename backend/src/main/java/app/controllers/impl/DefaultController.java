package app.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @GetMapping("/")
    public String main(HttpServletResponse response) throws IOException {
        response.sendRedirect("/suc");
        return "Welcome to Spring Boot server";
    }
    @GetMapping("/suc")
    public String succes(){

        return "suc";
    }
}
