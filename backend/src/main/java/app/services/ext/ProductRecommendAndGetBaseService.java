package app.services.ext;

import app.algorithms.recommendations.impl.CommonRecommendations;
import app.dto.impl.ProductDTO;
import app.entities.Account;
import app.entities.Product;
import app.entities.Visit;
import app.mappers.impl.unidirectional.request.ProductGetRecommendedMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductRecommendAndGetBaseService extends CRUDService<Product,
                                                                   ProductDTO.Request.GetRecommended,
                                                                   ProductDTO.Response.GetBase,
                                                                   ProductRepository,
                                                                   ProductGetRecommendedMapper,
                                                                   ProductGetBaseMapper> {


    @Autowired
    VisitRepository visitRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CommonRecommendations commonRecommendations;

    @Override
    public Optional<ProductDTO.Response.GetBase> find(ProductDTO.Request.GetRecommended dto) {
        //ToDo переместить это в ProductGetAndGetBaseService для работы с типом DTO Get
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

    public Optional<List<ProductDTO.Response.GetBase>> recommend(ProductDTO.Request.GetRecommended dto) {
        List<Product> products = commonRecommendations.getFor(dto.getAccountId());
        return Optional.of(responseMapper.toDtoList(products));
    }
}
