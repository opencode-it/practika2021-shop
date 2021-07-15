package app.services.ext;

import app.dto.impl.ProductDTO;
import app.entities.Account;
import app.entities.Product;
import app.entities.Visit;
import app.mappers.impl.unidirectional.request.ProductGetMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductGetAndGetBaseService extends CRUDService<Product,
        ProductDTO.Request.Get,
        ProductDTO.Response.GetBase,
        ProductRepository,
        ProductGetMapper,
        ProductGetBaseMapper> {

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Optional<ProductDTO.Response.GetBase> find(ProductDTO.Request.Get dto) {
        Account account = accountRepository.findById(dto.getId())
                .orElseGet(Account::guest);
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
}
