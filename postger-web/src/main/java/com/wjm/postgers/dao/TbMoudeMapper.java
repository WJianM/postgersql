package com.wjm.postgers.dao;

import com.wjm.postgers.base.IBaseMapper;
import com.wjm.postgers.domain.TbMoude;
import org.springframework.stereotype.Repository;

@Repository
public interface TbMoudeMapper extends IBaseMapper<TbMoude> {

    public int getId();
}