package com.clickconcepts.data.service;

import com.clickconcepts.data.model.Recipe;

public interface RecipeService {

    Recipe save(Recipe recipe);

    Recipe getById(String id);

    void delete(Recipe recipe);
}
