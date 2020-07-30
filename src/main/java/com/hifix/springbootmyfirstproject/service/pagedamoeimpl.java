package com.hifix.springbootmyfirstproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hifix.springbootmyfirstproject.dao.UserMapper;
import com.hifix.springbootmyfirstproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class pagedamoeimpl implements  pagedamoe{
@Resource
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

    return userMapper.selectAllUser();

    }


}
