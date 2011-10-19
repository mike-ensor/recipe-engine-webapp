package com.clickconcepts.data.service;

import com.clickconcepts.data.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private MongoTemplate template;

    @Override
    public Recipe save(Recipe recipe) {
        // template.save(recipe)
        template.save(recipe);

        return recipe;
    }

    @Override
    public Recipe getById(String id) {
        return template.findById(id, Recipe.class);
    }

    @Override
    public void delete(Recipe recipe) {
        checkArgument(recipe != null && !isNullOrEmpty(recipe.getId()), "Recipe cannot be null and must have been saved");
        template.remove(recipe);
    }
}
