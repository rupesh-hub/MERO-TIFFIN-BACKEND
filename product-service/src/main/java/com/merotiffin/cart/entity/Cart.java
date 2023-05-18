package com.merotiffin.cart.entity;

import com.merotiffin.shared.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Cart extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_id_seq_gen")
    @SequenceGenerator(name = "product_category_id_seq_gen", sequenceName = "product_category_id_seq_gen", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private Long productId;
    private String title;
    private Double price;
    private Integer quantity;
    private String image;

}
