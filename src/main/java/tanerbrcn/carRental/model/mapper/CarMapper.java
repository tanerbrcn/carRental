package tanerbrcn.carRental.model.mapper;

import org.springframework.stereotype.Component;
import tanerbrcn.carRental.model.dto.CarDTO;
import tanerbrcn.carRental.model.entity.Car;

@Component
public class CarMapper {

    //Car'daki verileri CarDTO'ya set eden fonksiyondur.
    public static CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setModelYear(car.getModelYear());
        carDTO.setDailyPrice(car.getDailyPrice());
        carDTO.setDescription(car.getDescription());
        return carDTO;
    }

    //CarDTO'daki verileri Car'a set eden fonksiyondur.
    public static Car toCar(CarDTO carDTO) {
        Car car = new Car();
        car.setModelYear(carDTO.getModelYear());
        car.setDailyPrice(carDTO.getDailyPrice());
        car.setDescription(carDTO.getDescription());
        return car;
    }
}
