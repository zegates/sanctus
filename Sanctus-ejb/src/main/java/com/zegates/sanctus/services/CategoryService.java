package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.CategoryBeanRemote;
import com.zegates.sanctus.entity.Category;
import com.zegates.sanctus.services.remote.CategoryServiceRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.CategoryServiceRemote", serviceName = "CategoryService", targetNamespace = "http://localhost/agency/category")
public class CategoryService implements CategoryServiceRemote{

    @EJB//(mappedName = "CategoryBean")
    private CategoryBeanRemote categoryBean;

    @PostConstruct
    private void ejbInit(){

    }

    @Override
    public void create(Category category) {
        categoryBean.create(category);
    }

    @Override
    public void edit(Category category) {
        categoryBean.edit(category);
    }

    @Override
    public void destroy(Long id) {
        categoryBean.destroy(id);
    }

    @Override
    public List<Category> findConstructionEntities() {
        return categoryBean.findConstructionEntities();
    }

    @Override
    public List<Category> findConstructionEntitiesLimit(int maxResults, int firstResult) {
        return categoryBean.findConstructionEntities(maxResults, firstResult);
    }

    @Override
    public Category findConstruction(Long id) {
        return findConstruction(id);
    }

    @Override
    public int getConstructionCount() {
        return categoryBean.getConstructionCount();
    }

    @Override
    public Category getConstructionForName(String name) {
        return categoryBean.getConstructionForName(name);
    }
}
