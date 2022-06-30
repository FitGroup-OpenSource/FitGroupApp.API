package com.fit.fitgroup.membership.mapping;

import com.fit.fitgroup.membership.domain.model.Membership;
import com.fit.fitgroup.membership.resource.MembershipResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MembershipMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public MembershipResource toResource(Membership model) {
        return mapper.map(model, MembershipResource.class);
    }

    public Page<MembershipResource> modelListPage(List<Membership> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MembershipResource.class), pageable, modelList.size());
    }
}
