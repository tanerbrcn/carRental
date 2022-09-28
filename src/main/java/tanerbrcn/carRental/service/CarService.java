package tanerbrcn.carRental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tanerbrcn.carRental.model.dto.CarDTO;
import tanerbrcn.carRental.model.entity.Car;
import tanerbrcn.carRental.model.mapper.CarMapper;
import tanerbrcn.carRental.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        List<Car> allCar = carRepository.findAll();
        return allCar;
    }

    public Car getCarById(Long id) {
        Optional<Car> byId = carRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Car not found!"));
    }

    //CarDTO'dan verileri alıp Car oluşturup car içerisine atıyor ve o car'ı veritabanına yazıyor.
    public Car createCar(CarDTO carDTO) {
        Car car = CarMapper.toCar(carDTO);
        Car saveCar = carRepository.save(car);
        return saveCar;
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, CarDTO carDTO) {
        Optional<Car> byId = carRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        Car updatedCar = byId.get();
        if (!StringUtils.isEmpty(carDTO.getModelYear())) {
            updatedCar.setModelYear(carDTO.getModelYear());
        }
        if (!StringUtils.isEmpty(carDTO.getModelYear())) {
            updatedCar.setDailyPrice(carDTO.getDailyPrice());
        }
        if (!StringUtils.isEmpty(carDTO.getModelYear())) {
            updatedCar.setDescription(carDTO.getDescription());
        }
        return carRepository.save(updatedCar);
    }


}
