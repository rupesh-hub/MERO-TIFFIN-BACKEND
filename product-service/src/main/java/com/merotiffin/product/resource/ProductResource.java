package com.merotiffin.product.resource;

import com.merotiffin.clients.IUserClient;
import com.merotiffin.product.service.IProductService;
import com.merotiffin.shared.model.PagingRequest;
import com.merotiffin.shared.model.ProductRequestPojo;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/products"})
@Api(value = "Product Management")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductResource {

    private final IProductService productService;
    private final IUserClient userClient;

    @PostMapping(path = {"/save-all"})
    public ResponseEntity<?> test(@RequestBody final Map<String, List<ProductRequestPojo>> products) {
        return new ResponseEntity(productService.saveAll(products), HttpStatus.CREATED);
    }

    @PostMapping(path = {"/paginated"})
    public ResponseEntity<?> allProductsByCategory(@RequestBody final PagingRequest pagingRequest) {
        return new ResponseEntity(productService.allProductsByCategory(pagingRequest), HttpStatus.OK);
    }

}
