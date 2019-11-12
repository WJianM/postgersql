package com.wjm.postgers.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.wjm.postgers.dao.SubjectDao;
import com.wjm.postgers.pojo.Subject;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Subject> findSearch(Map whereMap, int page, int size) {
		Specification<Subject> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return subjectDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Subject> findSearch(Map whereMap) {
		Specification<Subject> specification = createSpecification(whereMap);
		return subjectDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Subject findById(String id) {
		return subjectDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param subject
	 */
	public void add(Subject subject) {
		//subject.setId( idWorker.nextId()+"" );
		subjectDao.save(subject);
	}

	/**
	 * 修改
	 * @param subject
	 */
	public void update(Subject subject) {
		subjectDao.save(subject);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		subjectDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Subject> createSpecification(Map searchMap) {

		return new Specification<Subject>() {

			@Override
			public Predicate toPredicate(Root<Subject> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
