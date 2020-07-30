package com.hifix.springbootmyfirstproject.service;

import com.hifix.springbootmyfirstproject.dao.UserMapper;
import com.hifix.springbootmyfirstproject.pojo.User;
import com.hifix.springbootmyfirstproject.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class userloginimpl implements userlogin {
@Resource
    UserMapper userMapper;

    UserExample userexample;
    User user;
    @Override
    public User getuserlogin(String name, String password) {
       userexample=new UserExample();
        userexample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        System.out.println(name+password);
      //  User user=userMapper.selectByExample(userexample);
       // System.out.println(user);


       // return userMapper.selectBynameANDpassword(name, password);

return userMapper.selectByExample(userexample);
    }

    @Override
    public int adduser(String name, String password) {
        user=new User();

        user.setName(name);
        user.setPassword(password);
        return userMapper.insertSelective(user);
    }




}
