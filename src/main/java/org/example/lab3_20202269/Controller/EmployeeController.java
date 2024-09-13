package org.example.lab3_20202269.Controller;

import org.example.lab3_20202269.Entity.*;
import org.example.lab3_20202269.Repository.DepartmentRepository;
import org.example.lab3_20202269.Repository.EmployeeRepository;
import org.example.lab3_20202269.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    // Repositorios
    final JobRepository jobRepository;
    final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    // Listar todos los empleados
    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findByEnabled(1);

        model.addAttribute("employeeList", lista);
        return "lista";
    }

    @GetMapping("employee/info")
    public String informEmpleado(Model model, @RequestParam("id") int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            //List<Job> jobs = jobRepository.findAll();
            model.addAttribute("employee", employee);
            //model.addAttribute("jobs", jobs);
            return "info";
        } else {
            return "redirect:/lista";
        }
    }

    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("searchField") String searchField, Model model) {

        List<Employee> lista = employeeRepository.buscarPorNombre(searchField);
        model.addAttribute("lista", lista);
        model.addAttribute("textoBuscado", searchField);

        return "lista";
    }

    @GetMapping("/employee/delete")
    public String borrarEmpleado(Model model,
                                 @RequestParam("id") int id, RedirectAttributes redirectAttributes) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {

            Employee employee = optionalEmployee.get();
            //employeeRepository.deleteById(id);
            employee.setEnabled(0);

            employeeRepository.save(employee);

            redirectAttributes.addFlashAttribute("tipo_alert", "success");
            redirectAttributes.addFlashAttribute("msg", "Se borro el empleado");
        }
        return "redirect:/lista";

    }

}
