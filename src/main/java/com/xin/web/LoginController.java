package com.xin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login(){
        System.out.println(11111);
        return "hello";
    }

    @RequestMapping("/index")
    public String getIndex(HttpSession session){
        ArrayList<String> array = new ArrayList<>();
        array.add("圣诞节");
        array.add("春节");
        array.add("二月二龙抬头");
        array.add("元宵节");
        array.add("清明节");
        array.add("端午节");
        array.add("重阳节");
        array.add("除夕");
        array.add("除夕");

        session.setAttribute("array",array);
        return "index";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public Object testAjax1(String name,String address,String age){

        System.out.println("姓名："+name+"地址："+address+"年龄："+age);

        String jsonStr1 = "{\"name\":\"张三\",\"age\":23}";

        return jsonStr1;

    }
}
