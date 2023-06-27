package pl.webApplication.shop.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.webApplication.shop.category.model.Category;
import pl.webApplication.shop.category.repository.CategoryRepository;
import pl.webApplication.shop.product.model.Product;
import pl.webApplication.shop.product.repository.ProductRepository;

import java.awt.print.Pageable;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
//    private Category category;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

//    public Category getCategoriesWithProducts(Pageable pageable) {
//
//        Page<Product> page = productRepository.findByCategoryId(category.getId(), pageable);
//
//        return null;
//    }
}

