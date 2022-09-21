package com.example.payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payroll.Model.EmployeeEntity;

interface EmployeeRepository2 extends JpaRepository<EmployeeEntity, Long> {

}
