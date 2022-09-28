package tanerbrcn.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tanerbrcn.carRental.model.entity.Car;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {


}
