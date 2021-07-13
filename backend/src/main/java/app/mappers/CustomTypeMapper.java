package app.mappers;

import app.entities.ImageDuty;
import app.entities.Units;
import app.mappers.qualifiers.ImageDutyToString;
import app.mappers.qualifiers.StringToImageDuty;
import app.mappers.qualifiers.UnitsToString;
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

    @UnitsToString
    static String unitsToString(Units units) {
        return units.getName();
    }
}
