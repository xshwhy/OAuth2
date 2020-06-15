package com.iotmars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @ClassName ResouceServerConfig
 * @Description TODO
 * @Author xsh
 * @Date 2020-06-12 14:26
 * @Version 1.0
 **/
@Configuration
public class ResourceServerConfig  {

    public static final String RESOURCE_ID = "res1";


    /**
     * 统一认证(Uaa) 资源拦截
     */
    @Configuration
    @EnableResourceServer
    public class UaaServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            //设置我这个resource的id, 这个在auth中配置, 这里必须照抄
            resources.resourceId(RESOURCE_ID)  // 资源id
                    .tokenStore(tokenStore)
//                .tokenServices(tokenStore()) // 验证令牌的服务
                    //这个貌似是配置要不要把token信息记录在session中
                    .stateless(true);
        }


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/uaa/**").permitAll();
        }


    }

    /**
     * 订单服务
     */
    @Configuration
    @EnableResourceServer
    public class OrderServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            //设置我这个resource的id, 这个在auth中配置, 这里必须照抄
            resources.resourceId(RESOURCE_ID)  // 资源id
                    .tokenStore(tokenStore)
//                .tokenServices(tokenStore()) // 验证令牌的服务
                    //这个貌似是配置要不要把token信息记录在session中
                    .stateless(true);
        }


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/order/**").access("#oauth2.hasScope('ROLE_ADMIN')");
        }


    }


}
