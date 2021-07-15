package app.mappers.impl.unidirectional.response;

import app.dto.impl.OrdersDTO;
import app.dto.impl.ProductDTO;
import app.entities.Order;
import app.mappers.ResponseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Set;

@Mapper
public abstract class OrderGetFullMapper implements ResponseMapper<Order, OrdersDTO.Response.GetFull> {
    @Autowired
    private OrdersProductGetBaseMapper productBase;


    @Mapping(source = "id", target = "id")
    @Mapping(target = "accountId", ignore = true)

    @Mapping(target = "productsInOrder", ignore = true)
    @Mapping(target = "grandTotal", ignore = true)

    @Mapping(source = "date", target = "date")
    @Mapping(target = "status", ignore = true)


    @Override
    public abstract OrdersDTO.Response.GetFull toDto(Order entity);

    @AfterMapping
    void after(Order source, @MappingTarget OrdersDTO.Response.GetFull target) {
        Set<ProductDTO.Response.GetOrderedBase> orderedProducts = new HashSet<>();
        source.getOrdersProducts().forEach(op -> {
            orderedProducts.add(productBase.toDto(op));
        });

        target.setAccountId(source.getAccount().getId());
        target.setProductsInOrder(orderedProducts);

        BigDecimal grandTotal = countGrandTotalOf(source);

        target.setGrandTotal(grandTotal);
        target.setStatus(source.getOrderStatus().name());

    }

    private BigDecimal countGrandTotalOf(Order order) {
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
