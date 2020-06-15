package com.iotmars.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName PermissionPO
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-11 9:28
 * @Version 1.0
 **/
@Data
@TableName(value = "t_permission")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PermissionPO implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "code")
    private String code;

    @TableField(value = "description")
    private String description;

    @TableField(value = "url")
    private String url;

}
