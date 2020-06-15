package com.iotmars.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-10 16:31
 * @Version 1.0
 **/
@Data
@TableName(value = "t_user")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

    /**
     * 用户表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户中文拼音
     */
    @TableField(value = "username")
    private String username;
    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 用户姓名
     */
    @TableField(value = "fullname")
    private String fullname;
    /**
     * 用户手机号
     */
    @TableField(value = "mobile")
    private String mobile;


}
