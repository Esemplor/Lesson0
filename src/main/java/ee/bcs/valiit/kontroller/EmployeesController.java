package ee.bcs.valiit.kontroller;

import ee.bcs.valiit.solution.SolutionLesson1;
import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeesController {
    public List<Employees> employeesList = new ArrayList<>();
//    Employees employee = new Employees();
//        employee.setName("Arvo");
//        employee.setAddress("Tallinn");
//        employee.setAge(30);
//    Employees employee1 = new Employees();
//        employee1.setName("Jana");
//        employee1.setAddress("Tartu");
//        employee1.setAge(28);
//        employeesList.add(employee);
//        employeesList.add(employee1);

    @GetMapping("stuff/employee")
    public List<Employees> dtoGet() {
        return employeesList;
    }

    @GetMapping("stuff/employee/{x}")
    public Employees dtoGetid(@PathVariable("x") int x) {
        return employeesList.get(x);
    }

    @PostMapping("stuff/employee")
    public void dtoPost(@RequestBody Employees employee) {
        employeesList.add(employee);
    }

    @PutMapping("stuff/employee/{x}")
    public void dtoPut(@PathVariable("x") int index,@RequestBody Employees employee) {
        employeesList.set(index, employee);
    }
    @DeleteMapping("stuff/employee/{x}")
    public void dtoDelete(@PathVariable("x")int index){
        employeesList.remove(index);

    }


//    @GetMapping("stuff/employee")
//    public Employees dtoGet() {
//        Employees employee = new Employees();
//        employee.setName("Arvo");
//        employee.setAddress("Tallinn");
//        employee.setAge(30);
//        return employee;
//    }


}
