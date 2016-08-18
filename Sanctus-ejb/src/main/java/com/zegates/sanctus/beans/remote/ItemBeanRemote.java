package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Item;

import java.util.List;

/**
 * Created by sandaruwan on 8/14/16.
 */
public interface ItemBeanRemote {

    public boolean create(Item item);

    public void edit(Item item);

    public void destroy(Long id);

    List<Item> findItemEntities();

    List<Item> findItemEntities(int maxResults, int firstResult);

    Item findItem(Long id);

    int getItemCount();

    Item findItemForNameAndManu(String itemName, String manufacturer);
}
