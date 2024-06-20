package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customers customers;

    @ToString.Exclude
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerID;

    @Column(name = "order_date", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "required_date", columnDefinition = "DATE")
    private Date requiredDate;

    @Column(name = "shipped_date", columnDefinition = "DATE")
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;
}
