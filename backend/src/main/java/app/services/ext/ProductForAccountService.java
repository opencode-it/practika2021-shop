package app.services.ext;

import app.algorithms.recommendations.Recommendations;
import app.dto.NeedsRecommendationsDTO;
import app.dto.impl.ProductDTO;
import app.entities.Account;
import app.entities.Product;
import app.entities.Visit;
import app.mappers.impl.unidirectional.request.ProductForAccountMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.mappers.impl.unidirectional.response.ProductGetFullMapper;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Сервис, который сохраняет запись о визите при просмотре каталога
 * для последующего формирования рекомендаций
 * <p/>
 * Создать сервис
 * <pre>
 *     ProductForAccountService service =
 *          ProductForAccountService.with(typeRecommendations)
 * </pre>
 *
 * @author Александров Илья
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductForAccountService extends CRUDService<Product,
                                                          ProductDTO.Request.GetForAccount,
                                                          ProductDTO.Response.GetFull,
                                                          ProductRepository,
                                                          ProductForAccountMapper,
                                                          ProductGetFullMapper> {

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductGetBaseMapper baseMapper;

    @Autowired(required = false)
    Recommendations recommendations;

    private ProductForAccountService(Recommendations recommendations) {
        this.recommendations = recommendations;
    }

    public static ProductForAccountService with(Recommendations recommendations) {
        return new ProductForAccountService(recommendations);
    }

    public Optional<List<ProductDTO.Response.GetBase>> recommendFor(NeedsRecommendationsDTO dto) {
        List<Product> products = recommendations.getFor(dto.getAccountId());
        return Optional.of(baseMapper.toDtoList(products));
    }

    public Optional<ProductDTO.Response.GetFull> find(ProductDTO.Request.GetForAccount dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow();
        Product product = repository.findById(dto.getProductId())
                .orElseThrow();
        Visit visit = Visit.builder()
                .account(account)
                .reviewedProduct(product)
                .dateTime(LocalDateTime.now())
                .build();
        visitRepository.save(visit);
        return super.find(dto);
    }

}
