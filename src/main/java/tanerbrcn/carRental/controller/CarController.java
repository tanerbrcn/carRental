package tanerbrcn.carRental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tanerbrcn.carRental.model.dto.CarDTO;
import tanerbrcn.carRental.model.entity.Car;
import tanerbrcn.carRental.service.CarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/allCar")
    public List<Car> getAllCars() {
        List<Car> allCar = carService.getAllCars();
        return carService.getAllCars();
    }

    @PostMapping("/createCar")
    public ResponseEntity createNewUser(@RequestBody CarDTO carDTO) {
        Car respCar = carService.createCar(carDTO);
        if (respCar == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not add car");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable("id") Long id) {
        Car carById;
        try {
            carById = carService.getCarById(id);
        } catch (RuntimeException runtimeException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carById);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCarById(@PathVariable("id") Long id) {
        try {
            carService.deleteById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete failed car not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Delete successful");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCar(@PathVariable("id") Long id, @RequestBody CarDTO carDTO) {
        Car updateCar = carService.updateCar(id, carDTO);
        if (updateCar == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updateCar);
    }

}
