package com.wjm.postgers.domain;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_moude")
public class TbMoude implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select nextval('tb_moude_id_seq')")
    private Integer id;

    /**
     * 模块名称
     */
    private String name;

    /**
     * 路径

     */
    private String url;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 是否是叶子节点
     */
    private Integer isleaf;

    /**
     * 父id
     */
    private Integer pid;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取模块名称
     *
     * @return name - 模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模块名称
     *
     * @param name 模块名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取路径

     *
     * @return url - 路径

     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路径

     *
     * @param url 路径

     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取角色id
     *
     * @return rid - 角色id
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 设置角色id
     *
     * @param rid 角色id
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 获取是否是叶子节点
     *
     * @return isleaf - 是否是叶子节点
     */
    public Integer getIsleaf() {
        return isleaf;
    }

    /**
     * 设置是否是叶子节点
     *
     * @param isleaf 是否是叶子节点
     */
    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    /**
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", rid=").append(rid);
        sb.append(", isleaf=").append(isleaf);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }
}