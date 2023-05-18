package com.merotiffin.product.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.merotiffin.shared.model.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq_gen")
    @SequenceGenerator(name = "product_id_seq_gen", sequenceName = "product_id_seq_gen", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private String title;
    private Float discountPercentage;
    private Integer stock;
    private Float rating;
    private String thumbnail;
    private String image;
    private Double price;
    private long weight;

    @Column(name = "description", nullable = false, length = 500)
    private String description;
    private String userId;

}
