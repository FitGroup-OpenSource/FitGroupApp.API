package com.fit.fitgroup.membership.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("fitgroupMembershipMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public MembershipMapper membershipMapper() {
        return new MembershipMapper();
    }

}