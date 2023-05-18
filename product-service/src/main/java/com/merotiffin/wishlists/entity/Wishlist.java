package com.merotiffin.wishlists.entity;

import com.merotiffin.shared.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="wishlist")
@DynamicUpdate
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_id_seq_gen")
    @SequenceGenerator(name = "product_category_id_seq_gen", sequenceName = "product_category_id_seq_gen", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private Long productId;
    private String userId;

}
