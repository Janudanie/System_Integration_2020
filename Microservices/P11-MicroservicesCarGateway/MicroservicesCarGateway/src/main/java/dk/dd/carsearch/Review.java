package dk.dd.carsearch;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
//@NoArgsConstructor

@Entity
//@Document(collation = "review")
public class Review implements Serializable {

    @Id
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
