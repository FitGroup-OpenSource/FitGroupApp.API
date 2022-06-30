package com.fit.fitgroup.nutrition.service.security.domain.service.communication;

import com.fit.fitgroup.nutrition.service.security.resource.AuthenticateResource;
import com.fit.fitgroup.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}