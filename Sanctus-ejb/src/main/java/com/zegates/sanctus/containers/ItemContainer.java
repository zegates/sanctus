package com.zegates.sanctus.containers;

import com.zegates.sanctus.entity.Category;
import com.zegates.sanctus.entity.Item;
import com.zegates.sanctus.entity.Manufacturer;
import com.zegates.sanctus.entity.Metric;

/**
 * Created by sandaruwan on 8/28/16.
 */
public class ItemContainer {

    private Item item;
    private Metric metric;
    private Manufacturer manufacturer;
    private Category category;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
