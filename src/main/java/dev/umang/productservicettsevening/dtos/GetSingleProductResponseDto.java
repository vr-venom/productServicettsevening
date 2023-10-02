package dev.umang.productservicettsevening.dtos;

import dev.umang.productservicettsevening.modals.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
