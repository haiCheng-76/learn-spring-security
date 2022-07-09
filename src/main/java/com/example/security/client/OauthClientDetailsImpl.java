package com.example.security.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.security.constants.exceptions.LockedStatusClientException;
import com.example.security.sys.domain.OauthClientDetails;
import com.example.security.sys.mapper.OauthClientDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/9 23:14
 */
@Component(value = "oauthClientDetails")
public class OauthClientDetailsImpl implements ClientDetailsService, ClientRegistrationService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        QueryWrapper<OauthClientDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OauthClientDetails::getClientId, clientId);
        OauthClientDetails oauthClientDetails = oauthClientDetailsMapper.selectOne(queryWrapper);
        if (Objects.isNull(oauthClientDetails)) {
            throw new NoSuchClientException("不存在客户端");
        }
        Integer status = oauthClientDetails.getStatus();
        if (status == 1) {
            throw new LockedStatusClientException("客户端已锁定");
        }
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(oauthClientDetails.getClientId());
        details.setClientSecret(oauthClientDetails.getClientSecret());
        return details;
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        BaseClientDetails baseClientDetails = (BaseClientDetails) clientDetails;
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {

    }

    @Override
    public void updateClientSecret(String s, String s1) throws NoSuchClientException {

    }

    @Override
    public void removeClientDetails(String s) throws NoSuchClientException {

    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return null;
    }
}
