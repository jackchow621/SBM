package com.ghost.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghost.entity.Task;
import com.ghost.entity.User;
import com.ghost.mapper.TaskMapper;
import com.ghost.mapper.UserMapper;
import com.ghost.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskMapper taskMapper;


    @Override
    public void saveUser(User user){
//        Task task = new Task();
//        task.setName("task 100");
//        task.setDescript("task100 descriot");
//        task.setState(1);
//        taskMapper.insertTask(task);

//        List<Task> list = taskMapper.selectByState(0);
//        System.out.println(list.size());
//        for(Task t : list){
//            System.out.println(t.getName());
//        }

        List<User> users = userMapper.selectByState(0);
        for(User u : users){
            System.out.println(u.getUsername());
        }
    }
}
