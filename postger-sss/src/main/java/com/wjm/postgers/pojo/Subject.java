package com.wjm.postgers.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="subject")
public class Subject implements Serializable{

	@Id
	@GeneratedValue
	private Integer id;//


//	@Column(length = 36)
	private String name;//名称
	private Integer level;//等级

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {		
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}


	
}
