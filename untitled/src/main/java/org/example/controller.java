package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private repo rep;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody CreateEmployee createEmployee){
        return rep.save(new Employee(createEmployee));
    }

    @GetMapping("/")
    public List<Employee> getAll(){
        return rep.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){

        return rep.findById(id).get();
    }
}
