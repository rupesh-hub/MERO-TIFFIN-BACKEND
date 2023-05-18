package com.merotiffin.wishlists.resource;

import com.merotiffin.shared.model.CartResponsePojo;
import com.merotiffin.wishlists.entity.Wishlist;
import com.merotiffin.wishlists.service.IWishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/wishlists")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class WishlistResource {

    private final IWishlistService wishlistService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody final Wishlist wishlist) {
        return new ResponseEntity(wishlistService.save(wishlist), HttpStatus.CREATED);
    }

    @GetMapping("/paginated")
    public ResponseEntity<CartResponsePojo> getCartItems(@RequestParam("userId") final String userId,
                                                         @RequestParam(name = "current", defaultValue = "1") final Integer current,
                                                         @RequestParam(name = "size", defaultValue = "5") final Integer size) {
        return new ResponseEntity(wishlistService.wishlistByUser(userId, current, size), HttpStatus.OK);
    }


    @GetMapping("/size/{userId}")
    public ResponseEntity<?> favoriteSize(@PathVariable final String userId) {
        return new ResponseEntity(wishlistService.favoriteSize(userId), HttpStatus.OK);
    }

    @GetMapping("/delete/{productId}")
    public ResponseEntity<?> deleteWishlist(@PathVariable final Long productId) {
        return new ResponseEntity(wishlistService.deleteByProductId(productId), HttpStatus.OK);
    }

}
