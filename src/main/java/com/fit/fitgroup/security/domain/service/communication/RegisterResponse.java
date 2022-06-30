package com.fit.fitgroup.security.domain.service.communication;

import com.fit.fitgroup.security.resource.UserResource;
import com.fit.fitgroup.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}