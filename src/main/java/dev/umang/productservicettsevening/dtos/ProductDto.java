package dev.umang.productservicettsevening.dtos;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
