package com.iotmars.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iotmars.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-10 16:36
 * @Version 1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
