package com.merotiffin.shared.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductPojo {

    private Long id;
    private String title;
    private Double price;
    private long weight;
    private String description;
    private String image;
    private int stock;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Boolean isActive;
    private String userId;
    private Float discountPercentage;
    private Float rating;
    private String thumbnail;
    private ProductCategoryPojo category;
    private UserPojo user;

}

