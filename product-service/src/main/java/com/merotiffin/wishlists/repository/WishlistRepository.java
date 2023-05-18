package com.merotiffin.wishlists.repository;

import com.merotiffin.wishlists.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query(nativeQuery = true, value = "select count(*) from wishlist where created_by = ?1")
    Integer findWishlistSize(String userId);

    @Query(nativeQuery = true, value = "select count(*) from wishlist where product_id = ?1")
    Integer findWishlistByProductId(Long productId);
}
