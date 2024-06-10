package com.spring__kafka.product.Service;

import com.spring__kafka.product.Config.KafkaProducer;
import com.spring__kafka.product.Model.Product;
import com.spring__kafka.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        kafkaProducer.sendMassege(createdProduct);
        return createdProduct;
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        Product updatedProduct = productRepository.save(product);
        kafkaProducer.sendMassege(updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
