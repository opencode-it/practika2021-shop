package app.dto.interfaces.order;

import app.dto.impl.ProductDTO;

import java.util.Set;

public interface ProductsInfo {
    Set<ProductDTO.Response.GetOrderedBase> getProductsInOrder();
}
