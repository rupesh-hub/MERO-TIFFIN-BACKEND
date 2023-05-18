package com.merotiffin.shared.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartPojo {

    private Long productId;
    private String title;
    private Double price;
    private Integer quantity;
    private String image;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Boolean isActive;

}
