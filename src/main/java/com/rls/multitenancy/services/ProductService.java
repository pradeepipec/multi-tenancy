package com.rls.multitenancy.services;



import com.rls.multitenancy.model.ProductValue;

import java.util.List;

public interface ProductService {

    List<ProductValue> getProducts();

    ProductValue getProduct(long productId);

    ProductValue createProduct(ProductValue productValue);

    ProductValue updateProduct(ProductValue productValue);

    void deleteProductById(long productId);
}
