package com.merotiffin.cart.convertor;

import com.merotiffin.cart.entity.Cart;
import com.merotiffin.shared.model.CartPojo;

public class CartConvertor {

    public static Cart toEntity(final CartPojo source) {
        final Cart cart = new Cart();
        cart.setTitle(source.getTitle());
        cart.setProductId(source.getProductId());
        cart.setPrice(source.getPrice());
        cart.setImage(source.getImage());
        cart.setCreatedBy(source.getCreatedBy());
        cart.setCreatedDate(source.getCreatedDate());
        cart.setModifiedBy(source.getModifiedBy());
        cart.setModifiedDate(source.getModifiedDate());
        cart.setQuantity(source.getQuantity());
        return cart;
    }

    public static CartPojo toPojo(final Cart source) {
        final CartPojo cartPojo = new CartPojo();
        cartPojo.setTitle(source.getTitle());
        cartPojo.setProductId(source.getProductId());
        cartPojo.setPrice(source.getPrice());
        cartPojo.setImage(source.getImage());
        cartPojo.setCreatedBy(source.getCreatedBy());
        cartPojo.setCreatedDate(source.getCreatedDate());
        cartPojo.setModifiedBy(source.getModifiedBy());
        cartPojo.setModifiedDate(source.getModifiedDate());
        return cartPojo;
    }

}
