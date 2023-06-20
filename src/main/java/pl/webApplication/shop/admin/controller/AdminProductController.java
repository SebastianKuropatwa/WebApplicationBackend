package pl.webApplication.shop.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webApplication.shop.admin.controller.dto.AdminProductDto;
import pl.webApplication.shop.admin.model.AdminProduct;
import pl.webApplication.shop.admin.service.AdminProductService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    public static final Long EMPTY_ID = null;
    public final AdminProductService productService;

    @GetMapping("admin/products")
    public Optional<Optional<Page<AdminProduct>>> getProducts(Pageable pageable) {
        Optional<Page<AdminProduct>> products = productService.getProducts(pageable);

        return Optional.ofNullable(products);
    }

    @GetMapping("admin/products/{id}")
    public ResponseEntity<AdminProduct> getProduct(@PathVariable Long id) {
        Optional<AdminProduct> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product.get());
        }
    }
    @PostMapping("admin/products")
    public Optional<Optional<AdminProduct>> createProduct(@RequestBody @Valid AdminProductDto adminProductDto) {
        return Optional.ofNullable(productService.createProduct(mapAdminProduct(adminProductDto, EMPTY_ID)));
    }


    @PutMapping("admin/products/{id}")
    public ResponseEntity<AdminProduct> updateProduct(@RequestBody AdminProductDto adminProductDto, @PathVariable Long id) {
        AdminProduct updatedProduct = productService.updateProduct(mapAdminProduct(adminProductDto, id));

        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("admin/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    private static AdminProduct mapAdminProduct(AdminProductDto adminProductDto, Long id) {
        return AdminProduct.builder()
                .id(id)
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .category(adminProductDto.getCategory())
                .price(adminProductDto.getPrice())
                .currency(adminProductDto.getCurrency())
                .build();
    }
}
