package com.wjm.postgers.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjm.postgers.dao.TbMoudeMapper;
import com.wjm.postgers.domain.TbRole;
import com.wjm.postgers.domain.TbMoude;
import com.wjm.postgers.pojo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class MoudeService {
    @Autowired
    private TbMoudeMapper moudeMapper;

    public List<TbMoude> findAll() {
        return moudeMapper.selectAll();
    }

    public void save(TbMoude moude) {

        moude.setId(moudeMapper.getId());
        moudeMapper.insert(moude);
    }
    public PageResult<TbMoude> queryBrandPage(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 分页
        PageHelper.startPage(page, rows);

        Example example = new Example(TbRole.class);
        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + (desc ? " DESC" : " ASC"));
        }
        // 查询
        if(StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", key)
                    .orEqualTo("letter", key.toUpperCase());
        }
        List<TbMoude> list = this.moudeMapper.selectByExample(example);
        // 创建PageInfo
        PageInfo<TbMoude> info = new PageInfo<>(list);
        // 返回分页结果
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public TbMoude findById(int id) {
        return this.moudeMapper.selectByPrimaryKey(id);
    }

    public void update(TbMoude moude) {
        this.moudeMapper.updateByPrimaryKey(moude);
    }

    public void deleteById(int id) {
        this.moudeMapper.deleteByPrimaryKey(id);
    }
}
