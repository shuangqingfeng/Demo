package com.feng.controller;

import com.feng.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
//        ++id;
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        try {
//            user.setCreatTime(df.parse(df.format(new Date())));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        user.setId(id);
//        model.addAttribute("user", user);

        return "detail";
    }


}
