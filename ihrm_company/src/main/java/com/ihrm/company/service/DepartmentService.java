package com.ihrm.company.service;

/**
 * @Author: maoyu
 * @Date: 2020/4/17 16:20
 * @Description:
 */

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @Author kurt_39
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 新增
     *
     * @param department
     */
    public void addDepartment(Department department){
        // 生成主键
        department.setCompanyId(idWorker.nextId()+"");
        department.setCreateTime(new Date());
        departmentDao.save(department);
    }

    /**
     * 更新
     * @param department
     */
    public void updateDepartment(Department department){
        // 根据主键查询
        Department dept = departmentDao.findById(department.getId()).get();
        // 将可编辑的项插入
        dept.setIntroduce(department.getIntroduce());
        dept.setCompanyId(department.getCompanyId());
        dept.setManager(department.getManager());
        dept.setManagerId(department.getManagerId());
        dept.setName(department.getName());
        dept.setPid(department.getPid());
        departmentDao.save(dept);
    }

    /**
     * 根据主键查找
     *
     * @param id
     * @return Department
     */
    public Department findDepartmentById(String id){
        Department department = departmentDao.findById(id).get();
        if (null == department){
            return new Department();
        }
        return department;
    }

    /**
     * 查询所有Department
     * @return List
     */
    public List<Department> findDepartmentList(){
        List<Department> departmentList = departmentDao.findAll();
        if ( (null == departmentList) && (departmentList.size()<1) ){
            return Collections.emptyList();
        }
        return departmentList;
    }

    public void deleteDepartment(String id){
        departmentDao.deleteById(id);
    }

}
