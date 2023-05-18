package com.merotiffin.product.convertor;

import com.merotiffin.product.entity.Product;
import com.merotiffin.shared.model.ProductPojo;
import com.merotiffin.shared.model.ProductRequestPojo;

import java.time.LocalDateTime;
import java.util.List;

public class ProductConvertor {

    public static Product toEntity(final ProductPojo source) {
        final Product product = new Product();
        product.setId(source.getId());
        product.setTitle(source.getTitle());
        product.setPrice(source.getPrice());
        product.setDescription(source.getDescription());
        product.setStock(source.getStock());
        product.setImage(source.getImage());
        product.setCreatedDate(source.getCreatedDate());
        product.setCreatedBy(source.getCreatedBy());
        product.setModifiedDate(source.getModifiedDate());
        product.setModifiedBy(source.getModifiedBy());
        product.setDiscountPercentage(source.getDiscountPercentage());
        product.setRating(source.getRating());
        product.setThumbnail(source.getThumbnail());

        return product;
    }


    public static Product toEntity(final ProductRequestPojo source) {
        final Product product = new Product();

        product.setTitle(source.getTitle());
        product.setPrice(source.getPrice());
        product.setDescription(source.getDescription());
        product.setStock(source.getStock());
        product.setStock(source.getStock());
        product.setWeight(source.getWeight());
        product.setCreatedBy("");
        product.setCreatedDate(LocalDateTime.now());
        product.setDiscountPercentage(source.getDiscountPercentage());
        product.setRating(source.getRating());
        product.setThumbnail(source.getThumbnail());

        return product;
    }

    public static ProductPojo toPojo(final Product source) {
        final ProductPojo product = new ProductPojo();

        product.setId(source.getId());
        product.setTitle(source.getTitle());
        product.setPrice(source.getPrice());
        product.setDescription(source.getDescription());
        product.setStock(source.getStock());
        product.setImage(source.getImage());
        product.setCreatedDate(source.getCreatedDate());
        product.setCreatedBy(source.getCreatedBy());
        product.setModifiedDate(source.getModifiedDate());
        product.setModifiedBy(source.getModifiedBy());
        product.setDiscountPercentage(source.getDiscountPercentage());
        product.setRating(source.getRating());
        product.setThumbnail(source.getThumbnail());

        return product;
    }

    public static List<Product> toEntityList(final List<ProductRequestPojo> source) {
        return source.stream().map(ProductConvertor::toEntity).toList();
    }

    public static List<ProductPojo> toPojoList(final List<Product> source) {
        return source.stream().map(ProductConvertor::toPojo).toList();
    }

}
