package com.fit.fitgroup.nutrition.mapping;

import com.fit.fitgroup.nutrition.domain.model.model.Food;
import com.fit.fitgroup.nutrition.resource.FoodResource;
import com.fit.fitgroup.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class FoodMapper {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public FoodResource toResource(Food model) {
        return mapper.map(model, FoodResource.class);
    }

    public Page<FoodResource> modelListPage(List<Food> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FoodResource.class), pageable, modelList.size());
    }
}
