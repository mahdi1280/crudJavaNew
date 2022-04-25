package com.example.demo6.service;

import com.example.demo6.model.Product;
import com.example.demo6.repository.ProductRepository;
import com.example.demo6.request.ProductUpdateResponse;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(){
        this.productRepository = new ProductRepository();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void update(ProductUpdateResponse productUpdateResponse) {
        productRepository.update(productUpdateResponse);
    }

    public void remove(Integer id) {
        productRepository.remove(id);
    }
}
