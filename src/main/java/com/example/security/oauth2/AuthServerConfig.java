package com.example.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import javax.annotation.Resource;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/7 08:09
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource(name = "oauthClientDetails")
    private ClientDetailsService clientDetailsService;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        InMemoryClientDetailsService inMemoryClientDetailsService = new InMemoryClientDetailsService();
//        BaseClientDetails clientDetails = new BaseClientDetails();
//        clientDetails.setClientId("test");
//        clientDetails.setClientSecret("123");
//
//        List<String> scops = new ArrayList<>(1);
//        scops.add("read");
//        clientDetails.setScope(scops);
//
//        List<String> types = new ArrayList<>();
//        types.add("password");
//        clientDetails.setAuthorizedGrantTypes(types);
//
//        Map<String, BaseClientDetails> map = new HashMap<>();
//        map.put("client", clientDetails);
//        inMemoryClientDetailsService.setClientDetailsStore(map);
        clients.withClientDetails(clientDetailsService);
    }
}