package com.three.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.three.app.entity.Entity;


public interface EntityService extends IService<Entity> {

    Page<Entity> getEntities(Page<Entity> page);

    Page<Entity> getEntitiesList(Page<Entity> page,String CX,String sfzrkmc, String sfzckmc);
}
