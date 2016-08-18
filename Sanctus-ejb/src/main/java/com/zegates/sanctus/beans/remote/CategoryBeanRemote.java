package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Category;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface CategoryBeanRemote {
    void create(Category category);

    void edit(Category category);

    void destroy(Long id);

    List<Category> findConstructionEntities();

    List<Category> findConstructionEntities(int maxResults, int firstResult);

    Category findConstruction(Long id);

    int getConstructionCount();

    Category getConstructionForName(String name);
}
