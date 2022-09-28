package tanerbrcn.carRental.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private String modelYear;
    private Double dailyPrice;
    private String description;


}
