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
@Table(name = "customers")


public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Orders> orders;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastName;

    @Column(name = "contact_firstname")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String address1;

    @Column(name = "address_line2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    //select e.* from customers c, employee e where c.sales_rep_employee_id = e.id
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sales_rep_employee_id", nullable = true)
    private Employee employee;

    //bc we added the @manytoone annotation above, tihs column is now considered a duplicate in hibernate
    //  by adding the insertable = false and updatable = false, we're turning this into a read only variable
    @Column(name = "sales_rep_employee_id", columnDefinition = "INT", insertable = false, updatable = false)
    private Integer salesRepEmployeeID;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;


}
