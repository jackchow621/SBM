package com.ghost.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ghost.common.BaseMapper;
import com.ghost.entity.Task;

@Mapper
public interface TaskMapper extends BaseMapper<Task>{

	public void insertTask(Task task);
}
