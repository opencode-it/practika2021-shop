package app.services.ext.recommedations;

import app.algorithms.recommendations.impl.TypeRecommendations;
import app.services.ext.ProductForAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductTypeRecommendationsService extends ProductForAccountService<TypeRecommendations> {

}
