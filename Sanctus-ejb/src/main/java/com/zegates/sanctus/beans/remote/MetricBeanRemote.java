package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Metric;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface MetricBeanRemote {
    boolean createMetric(Metric metric);

    boolean edit(Metric metric);

    List<Metric> findMetrics();

    List<Metric> findMetrics(int maxResults, int firstResult);

    //    @Override
    List<Metric> findMetrics(boolean all, int maxResults, int firstResult);

    int getMetricCount();

    long getLatesOrdersID();
}
