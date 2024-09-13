package org.example.lab3_20202269.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", unique = true)
    private Integer departmentId;

    @Column(name = "department_name", length = 30)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
