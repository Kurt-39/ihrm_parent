package com.ihrm.company.dao;

/**
 * @Author: maoyu
 * @Date: 2020/3/20 12:08
 * @Description:
 */

import com.ihrm.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author kurt_39
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 **/
public interface CompanyDao extends JpaRepository<Company,String>, JpaSpecificationExecutor<Company> {
}
