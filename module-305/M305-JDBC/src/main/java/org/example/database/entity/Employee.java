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
@Table(name = "employees")

public class Employee {


    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    //this essentially a customerDAO.findByEmployeeId(123)
    // select c.* from customers c, employees e where c.sales_rep+employee_id = e.id and c.sales_rep_employee_id = <123>
    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customers> customers;

    @Column(name = "office_id")
    private Integer officeId;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private Integer vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    // lombok

}
