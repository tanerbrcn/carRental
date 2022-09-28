package tanerbrcn.carRental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tanerbrcn.carRental.model.entity.Color;
import java.util.List;
@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {

}
