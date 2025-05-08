package com.ecom.ecommerce.service;

import com.ecom.ecommerce.model.Product;
import com.ecom.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        Product p = productRepository.findByName(product.getName());
        product.setId(p.getId());
        productRepository.save(product);
    }

    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
