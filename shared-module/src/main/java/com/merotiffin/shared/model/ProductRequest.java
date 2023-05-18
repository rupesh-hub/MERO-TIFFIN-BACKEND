package com.merotiffin.shared.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductRequest {

    private Map<String, List<ProductRequestPojo>> products;

}