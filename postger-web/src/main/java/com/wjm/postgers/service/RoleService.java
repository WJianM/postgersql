package com.wjm.postgers.service;

import com.wjm.postgers.dao.TbRoleMapper;
import com.wjm.postgers.domain.TbRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private TbRoleMapper tbRoleMapper;

    public List<TbRole> findAll(){
//        tbRoleMapper.
        return tbRoleMapper.selectAll();
    }

    public void save(TbRole role) {
        tbRoleMapper.insert(role);
    }
}
