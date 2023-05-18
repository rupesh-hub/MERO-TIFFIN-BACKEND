package com.merotiffin.cart.service;

import com.merotiffin.shared.model.CartPojo;
import com.merotiffin.shared.model.CartResponsePojo;
import com.merotiffin.shared.util.GlobalResponse;

import java.util.List;

public interface ICartService {

    GlobalResponse<CartPojo> save(final CartPojo cart);

    GlobalResponse<List<CartResponsePojo>> cartProductByUser(final String userId, final Integer current, final Integer size);

    Integer cartSize(final String userId);

    GlobalResponse<Void> deleteByProductId(final Long productId);

}
