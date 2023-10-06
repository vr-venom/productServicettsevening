package dev.umang.productservicettsevening.inheritanceExample.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_TA")
public class TA extends User {
    private double averageRating;

}
