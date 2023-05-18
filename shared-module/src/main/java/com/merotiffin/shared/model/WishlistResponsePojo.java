package com.merotiffin.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistResponsePojo {

    private String title;
    private String categoryName;
    private String categoryDescription;
    private Long productId;
    private String image;
    private String createdBy;
    private Double price;
    private int stock;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private Boolean isActive;
    private UserPojo user;

}
