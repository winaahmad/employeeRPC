package com.example.payroll.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payroll.Model.EmployeeEntity;

interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
