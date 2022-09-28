package tanerbrcn.carRental.model.mapper;

import org.springframework.stereotype.Component;
import tanerbrcn.carRental.model.dto.BrandDTO;
import tanerbrcn.carRental.model.entity.Brand;

@Component
public class BrandMapper {

    public static BrandDTO toDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(brand.getName());
        return brandDTO;
    }

    public static Brand toBrand(BrandDTO brandDTO){
        Brand brand=new Brand();
        brand.setName(brandDTO.getName());
        return brand;
    }

}
