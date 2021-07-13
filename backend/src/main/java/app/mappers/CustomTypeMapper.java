package app.mappers;

import app.entities.ImageDuty;
import app.entities.ProductStatus;
import app.entities.ProductType;
import app.entities.Units;
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

}
