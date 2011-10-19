package com.clickconcepts.data.service;

import com.clickconcepts.data.model.Recipe;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mongo-db-context.xml"})
public class RecipeServiceImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RecipeService service;

    @Test
    public void testSave() throws Exception {
        Recipe recipe = new Recipe("My Recipe");
        assertThat(recipe.getId(), nullValue());

        Recipe savedRecipe = service.save(recipe);
        assertThat(savedRecipe.getId(), notNullValue());
    }

    @Test
    public void testSave_update() throws Exception {
        String recipeName = "My Recipe";
        Recipe recipe = new Recipe(recipeName);
        assertThat(recipe.getId(), nullValue());

        Recipe savedRecipe = service.save(recipe);
        assertThat(savedRecipe.getName(), is(recipeName));
        assertThat(savedRecipe.getId(), notNullValue());

        savedRecipe.setName(recipeName + " 2");
        Recipe updatedRecipe = service.save(savedRecipe);

        assertThat(updatedRecipe.getName(), is(recipeName + " 2"));
    }

    @Test
    public void testGet() throws Exception {
        Recipe recipe = new Recipe("My Recipe");
        recipe = service.save(recipe);

        Recipe savedRecipe = service.getById(recipe.getId());
        assertThat(savedRecipe.getId(), notNullValue());
    }

    @Test
    public void testGet_missing() throws Exception {
        Recipe savedRecipe = service.getById("missing");
        assertThat(savedRecipe, nullValue());
    }

    @Test
    public void testDelete() throws Exception {
        Recipe recipe = new Recipe("My Recipe");
        recipe = service.save(recipe);

        Recipe savedRecipe = service.getById(recipe.getId());
        assertThat(savedRecipe.getId(), notNullValue());

        service.delete(savedRecipe);

        savedRecipe = service.getById(recipe.getId());
        assertThat(savedRecipe, nullValue());
    }

    @Test
    public void testDelete_onNonSaved() throws Exception {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Recipe cannot be null and must have been saved");
        Recipe recipe = new Recipe("My Recipe");

        service.delete(recipe);
    }

}
