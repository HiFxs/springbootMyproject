package com.hifix.springbootmyfirstproject.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hifix.springbootmyfirstproject.pojo.User;

import com.hifix.springbootmyfirstproject.service.pagedamoeimpl;
import com.hifix.springbootmyfirstproject.service.userloginimpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {
    @Resource
    userloginimpl userloginimpl;

    @Resource
    pagedamoeimpl  pageimpl;

   @RequestMapping({"/","/index"})
    public String index(){
       return "login";

    }
@RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String userlogin(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session){

    User user=userloginimpl.getuserlogin(name,password);
    if(user==null){
    System.out.println("user is null");
    return "login";
}
    System.out.println(user.toString());
    return "dashborad";
}

@RequestMapping("/register")
public  String register(){
       return "register";
}

@RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public ModelAndView userregister(ModelAndView modelAndView, String name, String password){
    int l=0;
       l=userloginimpl.adduser(name,password);
       if(l==0){
           modelAndView.addObject("msg","注册失败请重新注册！");
           modelAndView.setViewName("redirect:/register");
           return modelAndView;
       }
       modelAndView.addObject("msg","注册成功请登录！");
       modelAndView.setViewName("login");
       return modelAndView;
}
//测试分页信息
@RequestMapping("/UserInfo")
public String presentUser(Model model,
                                  @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                  @RequestParam(defaultValue="2",value="pageSize")Integer pageSize)throws  Exception {

    if(pageNum == null){
        pageNum = 1;   //设置默认当前页
    }
    if(pageNum <= 0){
        pageNum = 1;
    }
    if(pageSize == null){
        pageSize = 2;    //设置默认每页显示的数据数
    }
    System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
//1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
//2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
    PageHelper.startPage(pageNum,pageSize);
    List<User> userList =pageimpl.getAllUser();

        System.out.println("分页数据："+userList);
        //3.使用PageInfo包装查询后的结果,5是连续 显示的条数,结果list类型是Page<E>
        PageInfo<User> pageInfo = new PageInfo<User>(userList,pageSize);
        //4.使用model/map/modelandview等带回前端

        model.addAttribute("pageInfo",pageInfo);





return "bootstraptable";


}



}
