package com.example.security.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/9 23:16
 */
@Getter
@Setter
@TableName(value = "t_oauth_client_details")
public class OauthClientDetails {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "client_id")
    private String clientId;

    @TableField(value = "client_secret")
    private String clientSecret;

    @TableField(value = "resource_ids")
    private String resourceIds;

    @TableField(value = "scope")
    private String scope;

    @TableField(value = "authorized_grant_types")
    private String authorizedGrantTypes;

    @TableField(value = "web_server_redirect_uri")
    private String webServerRedirectUri;
    @TableField(value = "authorities")
    private String authorities;

    @TableField(value = "access_token_validity")
    private Long accessTokenValidity;

    @TableField(value = "refresh_token_validity")
    private Long refreshTokenValidity;

    @TableField(value = "additional_information")
    private String additionalInformation;

    @TableField(value = "auto_approve")
    private Boolean autoApprove;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;

}
