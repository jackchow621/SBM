package com.ghost.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ghost.common.BaseMapper;
import com.ghost.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

	@Select("select * from user where state = #{state}")
    public List<User> selectByState(Integer state);
}
