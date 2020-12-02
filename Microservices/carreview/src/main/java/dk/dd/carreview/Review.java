package dk.dd.carreview;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.io.Serializable;

@Data
//@NoArgsConstructor


//@Document(collation = "review")
public class Review implements Serializable {


    private String id;
    private String writtenBy;
    private String review;
    private String brand;

    public String getWrittenBy() {
        return writtenBy;
    }


    public Review(@NonNull String writtenBy, @NonNull String review, @NonNull String brand) {
        this.writtenBy = writtenBy;
        this.review = review;
        this.brand = brand;
    }



    public Review(){}

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



}
