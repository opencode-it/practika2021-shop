package app.mappers.impl.unidirectional.response;

import app.dto.impl.OrdersDTO;
import app.dto.impl.ProductDTO;
import app.entities.Order;
import app.mappers.ResponseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public abstract class OrderGetFormedMapper implements ResponseMapper<Order, OrdersDTO.Response.GetFormed> {
    @Autowired
    private ProductGetBaseMapper productBase;

    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "productsInOrder", ignore = true)
    @Mapping(target = "grandTotal", ignore = true)

    @Override
    public abstract OrdersDTO.Response.GetFormed toDto(Order entity);

    @AfterMapping
    public void after(Order source, @MappingTarget OrdersDTO.Response.GetFormed target) {
        target.setAccountId(source.getAccount().getId());

        Set<ProductDTO.Response.GetBase> productsInFormedOrder = new HashSet<>();

        source.getOrdersProducts().forEach(op -> {
            var mappedProduct = productBase.toDto(op.getProduct());
            productsInFormedOrder.add(mappedProduct);
        });

        target.setProductsInOrder(productsInFormedOrder);
        target.setGrandTotal(countGrandTotal(source));
    }

    private BigDecimal countGrandTotal(Order order) {
        BigDecimal result = BigDecimal.valueOf(0);
        order.getOrdersProducts().forEach(op -> {
            result.add(op.getProduct().getPrice()
                    .multiply(
                            BigDecimal.valueOf(op.getCount())));

        });

        BigDecimal discount = result
                .divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(order.getDiscount().getValue()));

        result.subtract(discount);

        return result;
    }
}
