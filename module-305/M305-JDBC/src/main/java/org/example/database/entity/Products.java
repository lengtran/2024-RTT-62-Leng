package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "productline_id")
    private Integer productLineId;

    @Column(name = "product_scale")
    private String productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description")
    private String product_description;

    @Column(name = "quantity_in_stock", columnDefinition = "SMALLINT")
    private Integer quantityInStock;

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private Double buyPrice;

    @Column(name = "msrp", columnDefinition = "DECIMAL")
    private Double msrp;


}
