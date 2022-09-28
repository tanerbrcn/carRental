package tanerbrcn.carRental.model.mapper;

import org.springframework.stereotype.Component;
import tanerbrcn.carRental.model.dto.ColorDTO;
import tanerbrcn.carRental.model.entity.Color;

@Component
public class ColorMapper {

    public static ColorDTO toDTO(Color color){
        ColorDTO colorDTO =new ColorDTO();
        colorDTO.setName(color.getName());
        return colorDTO;
    }

    public static Color toColor(ColorDTO colorDTO){
        Color color =new Color();
        color.setName(colorDTO.getName());
        return color;
    }

}
