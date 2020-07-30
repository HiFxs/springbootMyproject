package com.hifix.springbootmyfirstproject.dao;

import com.hifix.springbootmyfirstproject.pojo.User;
import com.hifix.springbootmyfirstproject.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);
    List<User> selectAllUser();
    User selectByExample(UserExample example);
    User selectBynameANDpassword(String name,String password);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);





}