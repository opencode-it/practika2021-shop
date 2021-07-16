package app.dto.interfaces.filter;

import java.math.BigDecimal;

public interface PriceFilter {
    BigDecimal getMinPrice();

    BigDecimal getMaxPrice();
}
