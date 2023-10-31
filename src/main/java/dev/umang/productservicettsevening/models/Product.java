package dev.umang.productservicettsevening.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Category category;
    private String imgURL;
}
