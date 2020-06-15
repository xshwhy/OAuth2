package com.iotmars.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iotmars.entity.PermissionPO;
import com.iotmars.entity.UserPO;
import com.iotmars.mapper.PermissionMapper;
import com.iotmars.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpringDataUserDetailsService
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-10 14:42
 * @Version 1.0
 **/
@Service
@Slf4j(topic = "SpringDataUserDetailsService")
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据账号查询用户信息
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("账号名称:userName:{}",userName);
        // 将来连接数据库 根据账号查询用户信息
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        UserPO userPO = userMapper.selectOne(queryWrapper);
        if (StringUtils.isEmpty(userPO)) {
            return null;
        }
        // 根据用户的id 查询该用户的权限
        List<PermissionPO> pos = permissionMapper.findUserPermissionByUserId(userPO.getId());
        List<String> permissions = new ArrayList<>();
        pos.stream().forEach(p -> {
            permissions.add(p.getCode());
        });
        // permissions转换成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        // 暂时采用模拟方式
        String user = JSON.toJSONString(userPO);
        UserDetails userDetails = User.withUsername(user).password(userPO.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
