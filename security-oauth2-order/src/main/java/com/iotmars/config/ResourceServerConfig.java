package com.iotmars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    public static final String RESOURCE_ID = "res1";

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
                //本项目所需要的授权范围,这个scope是写在auth服务的配置里的
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')")
                .and().csrf().disable()
                //这个貌似是配置要不要把token信息记录在session中
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    //资源服务令牌解析服务
    /*@Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service=new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:8888/uaa/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service; }*/




}
