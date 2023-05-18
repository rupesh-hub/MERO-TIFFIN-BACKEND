package com.merotiffin.wishlists.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merotiffin.clients.IUserClient;
import com.merotiffin.shared.model.Pagination;
import com.merotiffin.wishlists.repository.WishlistRepository;
import com.merotiffin.wishlists.entity.Wishlist;
import com.merotiffin.shared.model.WishlistResponsePojo;
import com.merotiffin.shared.util.GlobalResponse;
import com.merotiffin.shared.util.GlobalUtil;
import com.merotiffin.wishlists.mapper.WishlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WishlistService implements IWishlistService {

    private final WishlistRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;
    private final IUserClient userClient;

    @Override
    public GlobalResponse<Wishlist> save(final Wishlist wishlist) {

        //validate product - is product already exists in wishlist
        if(wishlistRepository.findWishlistByProductId(wishlist.getProductId()) > 0)
            throw new RuntimeException(String.format("product already exists in wishlist."));

        wishlist.setCreatedBy(wishlist.getUserId());
        wishlist.setCreatedDate(LocalDateTime.now());
        wishlist.setIsActive(true);

        return GlobalUtil
                .globalResponse(
                        String.format("adding favorite product to cart success."),
                        HttpStatus.OK,
                        wishlistRepository.save(wishlist),
                        null
                );
    }

    @Override
    public GlobalResponse<List<WishlistResponsePojo>> wishlistByUser(String userId, Integer current, Integer size) {
        final Page page = wishlistMapper.wishlistByUser(new Page(current, size), userId);

        List<WishlistResponsePojo> records = page.getRecords();
        records.parallelStream().forEach(cartResponse -> {
            cartResponse.setUser(userClient.getUserByUserId(cartResponse.getCreatedBy()).getData());
        });

        return GlobalUtil
                .globalResponse(
                        String.format("fetching cart products by user id success."),
                        HttpStatus.OK,
                        records,
                        Pagination
                                .builder()
                                .page(page.getCurrent())
                                .pageSize(page.getSize())
                                .totalPages(page.getPages())
                                .totalRecords(page.getTotal())
                                .build()
                );
    }

    @Override
    public Integer favoriteSize(String userId) {
        return wishlistRepository.findWishlistSize(userId);
    }

    @Override
    public GlobalResponse<String> deleteByProductId(final Long productId) {
        wishlistMapper.deleteByProductId(productId);
        return GlobalUtil
                .globalResponse(
                        String.format("wishlist item deleted success."),
                        HttpStatus.OK,
                        null,
                        null
                );
    }

}
