package org.example.lab3_20202269.Repository;

import org.example.lab3_20202269.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEnabled(Integer enabled);
    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1")
    List<Employee> buscarPorNombre(String textoIngreso);

    @Query(nativeQuery = true, value = "SELECT * FROM employees where last_name = ?1")
    List<Employee> buscarPorApellido(String appellidoIngreso);
}
