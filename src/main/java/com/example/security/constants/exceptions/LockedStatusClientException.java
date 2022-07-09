package com.example.security.constants.exceptions;

import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/9 23:30
 */
public class LockedStatusClientException extends ClientRegistrationException {
    public LockedStatusClientException(String msg) {
        super(msg);
    }

    public LockedStatusClientException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
