package com.wjm.postgers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wjm.postgers.pojo.Moude;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MoudeDao extends JpaRepository<Moude,String>,JpaSpecificationExecutor<Moude>{
	
}
