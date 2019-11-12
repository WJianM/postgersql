package com.wjm.postgers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wjm.postgers.pojo.Subject;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SubjectDao extends JpaRepository<Subject,String>,JpaSpecificationExecutor<Subject>{
	
}
