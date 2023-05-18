package com.merotiffin.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestPojo {

    private String title;
    private Double price;
    private long weight;
    private String description;
    private String image;
    private int stock;
    private String userId;
    private Float discountPercentage;
    private Float rating;
    private String thumbnail;

}
