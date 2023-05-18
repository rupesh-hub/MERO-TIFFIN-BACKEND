package com.merotiffin.cart.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merotiffin.cart.convertor.CartConvertor;
import com.merotiffin.cart.mapper.CartMapper;
import com.merotiffin.cart.repository.CartRepository;
import com.merotiffin.clients.IUserClient;
import com.merotiffin.shared.model.CartPojo;
import com.merotiffin.shared.model.CartResponsePojo;
import com.merotiffin.shared.model.Pagination;
import com.merotiffin.shared.util.GlobalResponse;
import com.merotiffin.shared.util.GlobalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final IUserClient userClient;

    @Override
    @Transactional
    public GlobalResponse<CartPojo> save(final CartPojo cart) {
        if (cartRepository.findCartByProductId(cart.getProductId()) > 0)
            throw new RuntimeException("product already exists in cart");

        cart.setCreatedBy(cart.getCreatedBy());
        cart.setCreatedDate(LocalDateTime.now());
        cart.setIsActive(true);

        return GlobalUtil
                .globalResponse(
                        String.format("adding cart details and products details to cart success."),
                        HttpStatus.OK,
                        CartConvertor.toPojo(cartRepository.save(CartConvertor.toEntity(cart))),
                        null
                );
    }

    @Override
    public GlobalResponse<List<CartResponsePojo>> cartProductByUser(final String userId, final Integer current, final Integer size) {
        final Page cartResponsePage = cartMapper.cartProductByUser(new Page(current, size), userId);

        List<CartResponsePojo> records = cartResponsePage.getRecords();
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
                                .page(cartResponsePage.getCurrent())
                                .pageSize(cartResponsePage.getSize())
                                .totalPages(cartResponsePage.getPages())
                                .totalRecords(cartResponsePage.getTotal())
                                .build()
                );
    }

    @Override
    public Integer cartSize(String userId) {
        return cartRepository.findCartSize(userId);
    }

    @Override
    public GlobalResponse<Void> deleteByProductId(Long productId) {
        cartMapper.deleteByProductId(productId);
        return  GlobalUtil
                .globalResponse(
                        String.format("deleting cart item by product id success."),
                        HttpStatus.OK,
                        null,
                        null
                );
    }
}
