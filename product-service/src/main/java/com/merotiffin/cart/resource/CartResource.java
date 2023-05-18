package com.merotiffin.cart.resource;

import com.merotiffin.cart.service.ICartService;
import com.merotiffin.shared.model.CartPojo;
import com.merotiffin.shared.model.CartResponsePojo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CartResource {

    private final ICartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartPojo> save(@RequestBody final CartPojo cartPojo) {
        return new ResponseEntity(cartService.save(cartPojo), HttpStatus.CREATED);
    }

    @GetMapping("/size/{userId}")
    public ResponseEntity<CartResponsePojo> getCartSize(@PathVariable final String userId) {
        return new ResponseEntity(cartService.cartSize(userId), HttpStatus.OK);
    }

    @GetMapping("/paginated")
    public ResponseEntity<CartResponsePojo> getCartItems(@RequestParam("userId") final String userId,
                                                         @RequestParam(name = "current", defaultValue = "1") final Integer current,
                                                         @RequestParam(name = "size", defaultValue = "5") final Integer size) throws Exception {
//        TimeUnit.SECONDS.sleep(3);
        return new ResponseEntity(cartService.cartProductByUser(userId, current, size), HttpStatus.OK);
    }

    @GetMapping("/delete/{productId}")
    public ResponseEntity<?> deleteByProductId(@PathVariable("productId") final Long productId) {
        return new ResponseEntity(cartService.deleteByProductId(productId), HttpStatus.OK);
    }

}
