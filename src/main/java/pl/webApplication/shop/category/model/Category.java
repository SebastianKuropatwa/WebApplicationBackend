package pl.webApplication.shop.category.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import pl.webApplication.shop.product.model.Product;

import java.util.List;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "categoryId")
    private List<Product> products;
}
