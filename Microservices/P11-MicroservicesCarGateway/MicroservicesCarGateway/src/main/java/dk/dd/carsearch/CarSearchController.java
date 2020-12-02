package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarSearchController
{
    private CarSearchClient carClient = null;
    private ReviewSearchClient reviewClient = null;

    public CarSearchController(CarSearchClient carClient, ReviewSearchClient reviewClient)
    {
        this.carClient = carClient;
        this.reviewClient = reviewClient;
    }


    @GetMapping("/mycars")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    public Collection<Car> myCars()
    {
        return carClient.readCars()
                .getContent()
                .stream()
                .filter(this :: isMine)
                .collect(Collectors.toList());
    }


    @GetMapping("/reviews/{brand}")
    public Collection<Review> getReviewsByBrand (@PathVariable String brand){

        return reviewClient.readReviews().getContent().stream().filter(review -> review.getBrand().matches(brand)).collect(Collectors.toList());
    }



    private boolean isMine(Car car)
    {
        return  car.getBrand().equals("Mini") ||
                (car.getYear() > 2017 && car.getKm()< 100000);
    }

    private Collection<Car> fallback()
    {
        return new ArrayList<>();
    }
}