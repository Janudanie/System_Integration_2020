package dk.dd.carsearch;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@FeignClient("car-review")
@RibbonClient(name="car-review", configuration = RibbonConfig.class)
public interface ReviewSearchClient {
        @GetMapping("/reviews")
        Resources<Review> readReviews();
}
