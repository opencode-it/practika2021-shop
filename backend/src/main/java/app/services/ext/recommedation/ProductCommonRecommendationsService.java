package app.services.ext.recommedation;

import app.algorithms.recommendations.impl.CommonRecommendations;
import app.services.ext.ProductForAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCommonRecommendationsService extends ProductForAccountService<CommonRecommendations> {

}
