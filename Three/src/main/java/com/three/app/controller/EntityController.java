package com.three.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.three.app.common.R;
import com.three.app.entity.Entity;
import com.three.app.service.EntityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping("getEntities")
    @ResponseBody
    private R getEntities(Page<Entity> page){
        //page.setSize(50);

        return R.success(entityService.getEntities(page));
    }

    @GetMapping("getEntitiesList")
    @ResponseBody
    private R getEntitiesList(Page<Entity> page,String cx,String sfzrkmc, String sfzckmc) {
        page.setSize(100);
        if(cx.equals("undefined")){
            cx = null;
        }
        if(sfzrkmc.equals("undefined")){
            sfzrkmc = null;
        }
        if(sfzckmc.equals("undefined")){
            sfzckmc = null;
        }
        return R.success(entityService.getEntitiesList(page,cx,sfzrkmc,sfzckmc));
    }

    @RequestMapping("getEntitiesList")
    private String getEntitiesList(ModelMap modelMap,int current){
        Page<Entity> page = new Page<>();
        if(current != 0){
            page.setCurrent(current);
        }else {
            page.setCurrent(1);
        }
        page.setSize(50);
        modelMap.addAttribute("users",entityService.getEntities(page).getRecords());
        return "index";
    }

}
