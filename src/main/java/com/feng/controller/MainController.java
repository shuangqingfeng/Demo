package com.feng.controller;

import com.feng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fengunion on 2017/4/14.
 */
@Controller
public class MainController {
    private static int id;
    @RequestMapping("create")
    public String getCreate() {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("form") User user, ModelMap model) {
        ++id;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            user.setCreatTime(df.parse(df.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setId(id);
        model.addAttribute("user", user);

        return "detail";
    }


}
