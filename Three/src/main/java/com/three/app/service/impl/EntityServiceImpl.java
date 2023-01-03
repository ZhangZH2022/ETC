package com.three.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.three.app.entity.Entity;
import com.three.app.mapper.EntityMapper;
import com.three.app.service.EntityService;
import org.springframework.stereotype.Service;


@Service
public class EntityServiceImpl extends ServiceImpl<EntityMapper,Entity> implements EntityService {

    @Override
    public Page<Entity> getEntities(Page<Entity> page) {
        return baseMapper.getEntities(page);
    }

    @Override
    public Page<Entity> getEntitiesList(Page<Entity> page,
                                        String CX,
                                        String sfzrkmc,
                                        String sfzckmc) {
        return baseMapper.getEntitiesList(page,CX,sfzrkmc,sfzckmc);
    }
}
