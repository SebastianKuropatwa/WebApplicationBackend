package pl.webApplication.shop.review.model;

import jakarta.persistence.*;
import lombok.*;
import pl.webApplication.shop.product.model.Product;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "productId")
//    private Product product;


}

