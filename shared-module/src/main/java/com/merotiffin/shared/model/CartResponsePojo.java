package com.merotiffin.shared.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResponsePojo {

    private String productTitle;
    private Double unitPrice;
    private Integer quantity;
    private Double subTotal;
    private String categoryName;
    private String categoryDescription;
    private Long productId;
    private String image;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private Boolean isActive;
    private Integer wish;
    private UserPojo user;

}
