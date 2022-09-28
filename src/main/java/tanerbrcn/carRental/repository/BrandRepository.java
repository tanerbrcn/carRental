package tanerbrcn.carRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tanerbrcn.carRental.model.entity.Brand;
import java.util.List;
@Repository
public interface BrandRepository extends JpaRepository<Brand,Long>{
}
