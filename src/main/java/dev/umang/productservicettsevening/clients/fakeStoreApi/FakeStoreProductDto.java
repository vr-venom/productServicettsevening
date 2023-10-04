package dev.umang.productservicettsevening.clients.fakeStoreApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
