package com.merotiffin.product.service;

import com.merotiffin.shared.model.PagingRequest;
import com.merotiffin.shared.model.ProductPojo;
import com.merotiffin.shared.model.ProductRequestPojo;
import com.merotiffin.shared.util.GlobalResponse;

import java.util.List;
import java.util.Map;

public interface IProductService {

    GlobalResponse<Map<String, List<ProductRequestPojo>>> saveAll(final Map<String, List<ProductRequestPojo>> products);

    GlobalResponse<List<ProductPojo>> allProductsByCategory(final PagingRequest pagingRequest);

}

