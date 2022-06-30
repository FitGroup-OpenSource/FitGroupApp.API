package com.fit.fitgroup.training.mapping;

import com.fit.fitgroup.training.domain.model.Date;
import com.fit.fitgroup.training.domain.model.Trainer;
import com.fit.fitgroup.training.resource.DateResource;
import com.fit.fitgroup.training.resource.TrainerResource;
import com.fit.fitgroup.training.resource.SaveTrainerResource;
import com.fit.fitgroup.training.resource.UpdateTrainerResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DateMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public DateResource toResource(Date model) {
        return mapper.map(model, DateResource.class);
    }

    public Page<DateResource> modelListPage(List<Date> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DateResource.class), pageable, modelList.size());
    }


}
