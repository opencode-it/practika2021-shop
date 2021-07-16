package app.services.ext;

import app.algorithms.recommendations.Recommendations;
import app.dto.impl.ProductDTO;
import app.entities.Account;
import app.entities.Product;
import app.entities.Visit;
import app.mappers.impl.unidirectional.request.ProductForAccountMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import app.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Сервис, который сохраняет запись о визите при просмотре каталога
 * для последующего формирования рекомендаций
 * @param <T> тип рекомендаций
 *
 * @author Александров Илья
 */
public abstract class ProductForAccountService<T extends Recommendations> extends CRUDService<Product,
                                                                                              ProductDTO.Request.GetForAccount,
                                                                                              ProductDTO.Response.GetBase,
                                                                                              ProductRepository,
                                                                                              ProductForAccountMapper,
                                                                                              ProductGetBaseMapper> {

    @Autowired
    T recommendations;

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Optional<ProductDTO.Response.GetBase> find(ProductDTO.Request.GetForAccount dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow();
        Product product = repository.findById(dto.getAccountId())
                .orElseThrow();
        Visit visit = Visit.builder()
                .account(account)
                .reviewedProduct(product)
                .dateTime(LocalDateTime.now())
                .build();
        visitRepository.save(visit);
        return super.find(dto);
    }

    public Optional<List<ProductDTO.Response.GetBase>> recommendFor(ProductDTO.Request.GetForAccount dto) {
        List<Product> products = recommendations.getFor(dto.getAccountId());
        return Optional.of(responseMapper.toDtoList(products));
    }
}
