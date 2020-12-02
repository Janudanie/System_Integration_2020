package dk.dd.carreview;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository extends MongoRepository<Review, String> {

        public Review getAllBy(String id );
        public List<Review> getMyReviewsByWrittenBy(String writter);
        public List<Review> findByBrand(String brand);
}
