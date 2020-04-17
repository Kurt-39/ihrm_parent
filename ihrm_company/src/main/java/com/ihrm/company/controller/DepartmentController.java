package com.ihrm.company.controller;

/**
 * @Author: maoyu
 * @Date: 2020/4/17 17:10
 * @Description:
 */

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author kurt_39
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 **/
@RestController
@CrossOrigin
@RequestMapping("/company/department")
public class DepartmentController{
    @Autowired
    private DepartmentService departmentService;

    /**
     * 添加部门
     * @param department
     * @return Result
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return Result.SUCCESS();
    }

    /**
     * 更新部门
     * @param department
     * @return Result
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public Result updateDepartment(@PathVariable(name = "id")String id, @PathVariable Department department){
        department.setId(id);
        departmentService.updateDepartment(department);
        return Result.SUCCESS();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Result findDepartmentById(@PathVariable(name = "id")String id){
        Department department = departmentService.findDepartmentById(id);
        return new Result(ResultCode.SUCCESS,department);
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findDepartmentList(){
        return new Result(ResultCode.SUCCESS, departmentService.findDepartmentList());
    }

    /**
     * 根据id删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable(name = "id")String id){
        departmentService.deleteDepartment(id);
        return Result.SUCCESS();
    }


}
