package com.Zera57.ServerJPA.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByName = productRepository
                .findProductByName(product.getName());
        if (productByName.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new IllegalStateException(
                    "Product with id " + productId + " doesn't exists");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String name, String description, Integer cost, Integer count) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                    "Product with id " + productId + " doesn't exists"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(product.getName(), name)) {
            Optional<Product> productOptional = productRepository
                    .findProductByName(name);
            if (productOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            product.setName(name);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }
        if (cost != null &&
                cost > 0 &&
                !Objects.equals(product.getCost(), cost)) {
            product.setCost(cost);
        }
        if (count != null &&
                count >= 0 &&
                !Objects.equals(product.getCount(), count)) {
            product.setCost(count);
        }
    }
}
