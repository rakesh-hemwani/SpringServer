package com.demolabs.springserver.service;

import com.demolabs.springserver.model.Employee;
import com.demolabs.springserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Employee employee){
        repository.delete(employee);
    }
    public void deleteEmployeeById(Long employeeId){
        repository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees=new ArrayList<>();

        Streamable.of(repository.findAll()).
                forEach(employees::add);
        return employees;
    }
}
