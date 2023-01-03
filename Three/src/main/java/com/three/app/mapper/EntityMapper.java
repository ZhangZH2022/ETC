package com.three.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.three.app.entity.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EntityMapper extends BaseMapper<Entity> {

    Page<Entity> getEntities(@Param("page")Page<Entity> page);

    Page<Entity> getEntitiesList(Page<Entity> page,
                                 @Param("cx") String cx,
                                 @Param("sfzrkmc")String sfzrkmc,
                                 @Param("sfzckmc")String sfzckmc);
}
