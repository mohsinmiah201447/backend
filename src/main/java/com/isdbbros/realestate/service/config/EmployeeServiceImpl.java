package com.isdbbros.realestate.service.config;

import com.isdbbros.realestate.dao.config.EmployeeRepository;
import com.isdbbros.realestate.dto.Response;
import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.service.super_classes.config.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.isdbbros.realestate.RealEstateApplication.getCurrentUsername;
import static com.isdbbros.realestate.constants.enums.OperationStatus.FAILURE;
import static com.isdbbros.realestate.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Response storeData(Employee data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            employeeRepository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Employee>> getAll(Pageable pageable) {
        return new Response<>(SUCCESS, null, employeeRepository.findAll(pageable));
    }

    @Override
    public Response<Employee> getById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        return new Response<>(SUCCESS, null, employee);
    }

    @Override
    public Response delete(Long id) {
        employeeRepository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Employee data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Employee data) {
//        boolean employeenameExists;
//        if (data.hasId()) {
//            employeenameExists = employeeRepository.existsByEmployeename(data.getEmployeename(), data.getId());
//        } else {
//            employeenameExists = employeeRepository.existsByEmployeename(data.getEmployeename());
//        }
//        return employeenameExists ? "Failed to register. Employee already exists" : null;
        return null;
    }

}
