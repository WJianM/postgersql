package com.wjm.postgers.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjm.postgers.dao.TbUserMapper;
import com.wjm.postgers.domain.TbRole;
import com.wjm.postgers.domain.TbUser;
import com.wjm.postgers.pojo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private TbUserMapper userMapper;

    public List<TbUser> findAll() {
        return userMapper.selectAll();
    }

    public void save(TbUser user) {

        user.setId(userMapper.getId());
        userMapper.insert(user);
    }
    public PageResult<TbUser> queryBrandPage(
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
        List<TbUser> list = this.userMapper.selectByExample(example);
        // 创建PageInfo
        PageInfo<TbUser> info = new PageInfo<>(list);
        // 返回分页结果
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public TbUser findById(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    public void update(TbUser user) {
        this.userMapper.updateByPrimaryKey(user);
    }

    public void deleteById(int id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
