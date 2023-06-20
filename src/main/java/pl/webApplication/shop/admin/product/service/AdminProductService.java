package pl.webApplication.shop.admin.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.webApplication.shop.admin.product.model.AdminProduct;
import pl.webApplication.shop.admin.product.repository.AdminProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    public final AdminProductRepository productRepository;

    public Optional<Page<AdminProduct>> getProducts(Pageable pageable) {
        return Optional.of(productRepository.findAll(pageable));
    }

    public Optional<AdminProduct> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<AdminProduct> createProduct(AdminProduct adminProduct) {
        AdminProduct createdProduct = productRepository.save(adminProduct);
        return Optional.ofNullable(createdProduct);
    }

    public AdminProduct updateProduct(AdminProduct adminProduct) {
        return productRepository.save(adminProduct);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
