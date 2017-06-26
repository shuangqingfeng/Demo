package com.feng.controller;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Fengunion on 2017/6/21.
 */
@Controller
@RequestMapping("/app")
public class LoginController {
    @RequestMapping("/login")
    public void getLoginInfo(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject jsonObject = new JSONObject();
        response.setContentType("application/json;charset=utf-8");

        try {
            PrintWriter writer = response.getWriter();
            if (!(username.equals("张三") && password.equals("123456"))) {
                jsonObject.put("result", 1);
                jsonObject.put("message", "用户名和密码匹配");
                jsonObject.put("code", 1001);
            } else {
                jsonObject.put("result", 0);
                jsonObject.put("message", "登录成功");
                jsonObject.put("code", 1000);
            }
            writer.print(jsonObject.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
