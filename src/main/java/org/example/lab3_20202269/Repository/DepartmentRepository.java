package org.example.lab3_20202269.Repository;

import org.example.lab3_20202269.Entity.Department;
import org.example.lab3_20202269.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Employee, Integer> {

}
