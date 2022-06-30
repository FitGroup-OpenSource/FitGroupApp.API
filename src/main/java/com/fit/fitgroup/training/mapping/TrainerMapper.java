package com.fit.fitgroup.training.mapping;

import com.fit.fitgroup.training.domain.model.Trainer;
import com.fit.fitgroup.training.resource.TrainerResource;
import com.fit.fitgroup.training.resource.SaveTrainerResource;
import com.fit.fitgroup.training.resource.UpdateTrainerResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TrainerMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public TrainerResource toResource(Trainer model) {
        return mapper.map(model, TrainerResource.class);
    }

    public Page<TrainerResource> modelListPage(List<Trainer> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TrainerResource.class), pageable, modelList.size());
    }

    public Trainer toModel(SaveTrainerResource resource) {
        return mapper.map(resource, Trainer.class);
    }

    public Trainer toModel(UpdateTrainerResource resource) {
        return mapper.map(resource, Trainer.class);
    }

}
