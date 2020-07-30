package com.hifix.springbootmyfirstproject.service;

import com.hifix.springbootmyfirstproject.pojo.User;

public interface userlogin {
    User getuserlogin(String name, String password);
    int adduser(String name,String password);

}
