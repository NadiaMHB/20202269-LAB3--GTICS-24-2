package org.example.lab3_20202269.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.lab3_20202269.Entity.Department;
import org.example.lab3_20202269.Entity.Job;

@Getter
@Setter
@Entity
@Table(name ="employees" )
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;


    @Column(name = "phone_number", length = 20)
    private String phoneNumber;


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job jobId;

    @Column(name = "salary", precision = 8, scale = 2)
    private Double salary;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    /*@ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;*/

    @Column(name = "enabled", nullable = false)
    private Integer enabled;



}
