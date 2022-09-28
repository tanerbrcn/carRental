package tanerbrcn.carRental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tanerbrcn.carRental.model.dto.BrandDTO;
import tanerbrcn.carRental.model.entity.Brand;
import tanerbrcn.carRental.model.mapper.BrandMapper;
import tanerbrcn.carRental.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        List<Brand> allBrand = brandRepository.findAll();
        return allBrand;
    }

    public Brand getBrandById(Long id) {
        Optional<Brand> byId = brandRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Brand not found!"));
    }


    public Brand createBrand(BrandDTO brandDTO) {
        Brand brand = BrandMapper.toBrand(brandDTO);
        Brand saveBrand = brandRepository.save(brand);
        return saveBrand;
    }

    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    public Brand updateBrand(Long id, BrandDTO brandDTO) {
        Optional<Brand> byId = brandRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        Brand updatedBrand = byId.get();
        if (!StringUtils.isEmpty(brandDTO.getName())) {
            updatedBrand.setName(brandDTO.getName());
        }
        return brandRepository.save(updatedBrand);
    }


}
