package app.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.PathProvider;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.paths.Paths;

@Component
public class CustomPathProvider extends DefaultPathProvider implements PathProvider {

    @Value("${api.path:/}")
    private String path;

    @Override
    public String getOperationPath(String operationPath) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(path);
        return Paths.removeAdjacentForwardSlashes(uriComponentsBuilder.path(operationPath).build().toString());
    }
}