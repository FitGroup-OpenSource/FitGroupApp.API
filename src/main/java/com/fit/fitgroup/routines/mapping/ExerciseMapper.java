package com.fit.fitgroup.routines.mapping;

import com.fit.fitgroup.routines.domain.model.Exercise;
import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.resource.ExerciseResource;
import com.fit.fitgroup.routines.resource.RoutineResource;
import com.fit.fitgroup.routines.resource.SaveRoutineResource;
import com.fit.fitgroup.routines.resource.UpdateRoutineResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ExerciseMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ExerciseResource toResource(Exercise model) {
        return mapper.map(model, ExerciseResource.class);
    }

    public Page<ExerciseResource> modelListPage(List<Exercise> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ExerciseResource.class), pageable, modelList.size());
    }


}
