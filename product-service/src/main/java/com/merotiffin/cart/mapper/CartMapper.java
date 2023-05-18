package com.merotiffin.cart.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merotiffin.shared.model.CartPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

    Page<CartPojo> cartProductByUser(final Page<CartPojo> page,
                                     @Param("userId") final String userId);

    void deleteByProductId(final Long productId);
}
