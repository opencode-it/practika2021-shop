package app.mappers;

import app.entities.*;
import app.mappers.qualifiers.*;
import org.mapstruct.Mapper;

@Mapper
public interface CustomTypeMapper {

    @StringToImageDuty
    static ImageDuty stringToImageDuty(String name) {
        return ImageDuty.builder()
                .name(name)
                .build();
    }

    @ImageDutyToString
    static String imageDutyToString(ImageDuty imageDuty) {
        return imageDuty.getName();
    }

    @StringToProductType
    static ProductType stringToProductType(String name) {
        return ProductType.builder()
                .name(name)
                .build();
    }

    @ProductTypeToString
    static String productTypeToString(ProductType productType) {
        return productType.getName();
    }

    @UnitsToString
    static String unitsToString(Units units) {
        return units.getName();
    }

    @ProductStatusByDefault
    static ProductStatus statusByDefault() {
        return ProductStatus.WAIT_ACCEPTING;
    }

    @ProductStatusToString
    static String productStatusToString(ProductStatus status) {
        return status.name();
    }

    @ProductToString
    static String productToString(Product product) {
        return product.toString();
    }

    @IntegerToDiscount
    static Discount integerToDiscount(Integer value) {
        return Discount.builder()
                .value(value)
                .build();
    }

    @DiscountToInteger
    static Integer discountToInteger(Discount discount) {
        return discount.getValue();
    }

}
