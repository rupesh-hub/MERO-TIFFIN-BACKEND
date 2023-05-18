package com.merotiffin.wishlists.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merotiffin.shared.model.WishlistResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WishlistMapper {

    Page<WishlistResponsePojo> wishlistByUser(final Page<WishlistResponsePojo> page,
                                              @Param("userId") final String userId);

    void deleteByProductId(final Long productId);

}
