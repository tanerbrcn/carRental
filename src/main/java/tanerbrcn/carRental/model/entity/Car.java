package tanerbrcn.carRental.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car { //Araba

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    @Column(nullable = false)
    private int brandId;
    @Column(nullable = false)
    private int colorId;

    @Column(name = "model_year", nullable = false)
    private String modelYear;
    @Column(name = "daily_price", nullable = false)
    private Double dailyPrice;
    @Column(name = "description", nullable = false)
    private String description;

}
