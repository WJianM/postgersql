package com.wjm.postgers.dao;

import com.wjm.postgers.base.IBaseMapper;
import com.wjm.postgers.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper extends IBaseMapper<TbUser> {

    public int getId();
}