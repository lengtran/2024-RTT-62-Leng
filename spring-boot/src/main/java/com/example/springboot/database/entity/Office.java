package com.example.springboot.database.entity;

import com.example.springboot.database.entity.Employee;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offices")

public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "territory")
    private String territory;

//    // Add relationships if needed
//    // Example: One Office can have many Employees
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Employee> employees;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Office office = (Office) o;
//        return id == office.id && Objects.equals(city, office.city) && Objects.equals(phone, office.phone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, city, phone);
//    }
}
