package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Category;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CategoryServiceRemote{
    @WebMethod
    void create(Category category);
    @WebMethod
    void edit(Category category);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<Category> findConstructionEntities();
    @WebMethod
    List<Category> findConstructionEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    Category findConstruction(Long id);
    @WebMethod
    int getConstructionCount();
    @WebMethod
    Category getConstructionForName(String name);
}
