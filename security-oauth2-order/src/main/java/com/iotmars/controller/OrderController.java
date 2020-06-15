package com.iotmars.controller;

import com.iotmars.util.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-12 14:25
 * @Version 1.0
 **/
@RestController
public class OrderController {


    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1() {
        UserDTO user = (UserDTO) SecurityContextHolder.getContext().getAuthentication();

        return user.getUsername()+user.getMobile()+"访问资源1";
    }

}
