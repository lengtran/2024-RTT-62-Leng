package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")

public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id", nullable = true)
    private Orders orders;

    @Column(name = "order_id", insertable=false, updatable=false)
    private Integer orderId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered = 0;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private Double priceEach = 0.00;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "product_id", nullable = true)
    private Products products;


}
