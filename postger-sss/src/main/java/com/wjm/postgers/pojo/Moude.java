package com.wjm.postgers.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_moude")
public class Moude implements Serializable{

	@Id
	@GeneratedValue
	private Integer id;//


//	@Column(length = 36)
	private String name;//模块名称
//	@Column(length = 36)
	private String url;//url路径
	private Integer rid;//所属id
	private Integer isleaf;//是否是叶子
	private Integer pid;//父id

	
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

	public String getUrl() {		
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getRid() {		
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}

	public Integer getPid() {		
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}


	
}
