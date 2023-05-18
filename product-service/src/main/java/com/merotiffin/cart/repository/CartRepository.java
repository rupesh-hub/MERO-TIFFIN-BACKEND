package com.merotiffin.cart.repository;

import com.merotiffin.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(nativeQuery = true, value = "select count(*) from cart where created_by = ?1")
    Integer findCartSize(String userId);

    @Query(nativeQuery = true, value = "select count(*) from cart where product_id = ?1")
    Integer findCartByProductId(Long productId);
}
