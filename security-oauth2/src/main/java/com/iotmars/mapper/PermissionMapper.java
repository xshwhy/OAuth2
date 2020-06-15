package com.iotmars.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iotmars.entity.PermissionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PermissionMapper
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-11 9:30
 * @Version 1.0
 **/
@Mapper
public interface PermissionMapper extends BaseMapper<PermissionPO> {

    /**
     * 查询该用户权限
     * @param userId 用户id
     * @return
     */
    List<PermissionPO> findUserPermissionByUserId(@Param(value = "userId") Integer userId);


}
