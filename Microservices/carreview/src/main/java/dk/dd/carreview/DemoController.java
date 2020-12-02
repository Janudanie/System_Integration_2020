package dk.dd.carreview;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource
@ResponseBody
@RestController
@RequestMapping("/reviews")
public class DemoController  {

    @Autowired
    private ReviewRepository repository;


    @GetMapping("/")
    public List<Review> getReviews(){
        return(List<Review>) repository.findAll();
    }

    @GetMapping("/{brand}")
    public List<Review> getReviewsByBrand(@PathVariable String brand){

        return repository.findByBrand(brand);
    }

    @GetMapping("/author/{writer}")
    public List<Review> getReviewsByAuthor(@PathVariable String writer){
        return repository.getMyReviewsByWrittenBy(writer);
    }




}
