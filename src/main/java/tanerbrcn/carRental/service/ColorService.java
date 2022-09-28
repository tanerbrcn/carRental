package tanerbrcn.carRental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tanerbrcn.carRental.model.dto.BrandDTO;
import tanerbrcn.carRental.model.dto.ColorDTO;
import tanerbrcn.carRental.model.entity.Brand;
import tanerbrcn.carRental.model.entity.Color;
import tanerbrcn.carRental.model.mapper.BrandMapper;
import tanerbrcn.carRental.model.mapper.ColorMapper;
import tanerbrcn.carRental.repository.BrandRepository;
import tanerbrcn.carRental.repository.ColorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    public List<Color> getAllBrands() {
        List<Color> allColor = colorRepository.findAll();
        return allColor;
    }

    public Color getColorById(Long id) {
        Optional<Color> byId = colorRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Color not found!"));
    }

    public Color createColor(ColorDTO colorDTO) {
        Color color = ColorMapper.toColor(colorDTO);
        Color saveColor = colorRepository.save(color);
        return saveColor;
    }

    public void deleteById(Long id) {
        colorRepository.deleteById(id);
    }

    public Color updateColor(Long id, ColorDTO colorDTO) {
        Optional<Color> byId = colorRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        Color updatedColor = byId.get();
        if (!StringUtils.isEmpty(colorDTO.getName())) {
            updatedColor.setName(colorDTO.getName());
        }
        return colorRepository.save(updatedColor);
    }

}
