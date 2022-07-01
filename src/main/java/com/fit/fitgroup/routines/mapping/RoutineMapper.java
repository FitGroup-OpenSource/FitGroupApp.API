package com.fit.fitgroup.routines.mapping;

import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.resource.RoutineResource;
import com.fit.fitgroup.routines.resource.SaveRoutineResource;
import com.fit.fitgroup.routines.resource.UpdateRoutineResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RoutineMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public RoutineResource toResource(Routine model) {
        return mapper.map(model, RoutineResource.class);
    }

    public Page<RoutineResource> modelListPage(List<Routine> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RoutineResource.class), pageable, modelList.size());
    }

    public Routine toModel(SaveRoutineResource resource) {
        return mapper.map(resource, Routine.class);
    }

    public Routine toModel(UpdateRoutineResource resource) {
        return mapper.map(resource, Routine.class);
    }

}
