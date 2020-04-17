package com.ihrm.company.dao;

import com.ihrm.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: maoyu
 * @Date: 2020/4/17 16:18
 * @Description:
 */
public interface DepartmentDao extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
}
