package app.mappers.impl.unidirectional.request;

import app.dto.impl.OrdersDTO;
import app.dto.impl.ProductDTO;
import app.entities.Account;
import app.entities.Order;
import app.entities.OrdersProducts;
import app.entities.Product;
import app.mappers.CustomTypeMapper;
import app.mappers.RequestMapper;
import app.mappers.qualifiers.IntegerToDiscount;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.ProductRepository;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(uses = CustomTypeMapper.class)
public abstract class OrderProductsConfirmMapper implements
        RequestMapper<Order, OrdersDTO.Request.ConfirmOrder> {
    @Autowired
    private AccountRepository accs;
    @Autowired
    private ProductRepository products;

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "ordersProducts", ignore = true)
    @Mapping(source = "discount", target = "discount", qualifiedBy = IntegerToDiscount.class)
    @Override
    public abstract Order toEntity(OrdersDTO.Request.ConfirmOrder dto);

    @AfterMapping
    public void boundProducts(OrdersDTO.Request.ConfirmOrder source, @MappingTarget  Order target) {
        Account orderedAcc = accs.getOne(source.getAccountId());
        target.setAccount(orderedAcc);
        List<OrdersProducts> orderedProducts = new ArrayList<>(){
            {
                source.getOrderedProductIds().entrySet().stream().forEach(pa -> {
                    Product orderedProduct = products.getOne(pa.getKey());
                    Integer amount = pa.getValue();

                    OrdersProducts op = new OrdersProducts();
                    op.setProduct(orderedProduct);
                    op.setCount(amount);

                    add(op);
                });
            }
        };

        target.setOrdersProducts(orderedProducts);
        target.setDate(LocalDateTime.now());

        //TODO я не уверена, как лучше ставить новый статус заказа: они же сохранены в бд?
    }
}
