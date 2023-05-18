package com.merotiffin.wishlists.service;

import com.merotiffin.wishlists.entity.Wishlist;
import com.merotiffin.shared.model.WishlistResponsePojo;
import com.merotiffin.shared.util.GlobalResponse;

import java.util.List;
import java.util.Map;

public interface IWishlistService {

    GlobalResponse<Wishlist> save(final Wishlist wishlist);

    GlobalResponse<List<WishlistResponsePojo>> wishlistByUser(final String userId, final Integer current, final Integer size);

    Integer favoriteSize(final String userId);

    GlobalResponse<String> deleteByProductId(Long productId);
}
