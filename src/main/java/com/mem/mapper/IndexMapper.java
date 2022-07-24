package com.mem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mem.model.Index;
import org.apache.ibatis.annotations.Select;


public interface IndexMapper extends BaseMapper<Index> {

    @Select("select * from `index` order by rand() LIMIT 1")
    Index getOne();
}
