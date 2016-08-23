package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.MetricBeanRemote;
import com.zegates.sanctus.entity.Metric;
import com.zegates.sanctus.services.remote.MetricServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.MetricServiceRemote", serviceName = "MetricService", targetNamespace = "http://localhost/agency/metric")
public class MetricService implements MetricServiceRemote {

    @EJB//(mappedName = "MetricBean")
    MetricBeanRemote metricBean;

    @Override
    @WebMethod
    public boolean createMetric(Metric metric) {
        return metricBean.createMetric(metric);
    }

    @Override
    @WebMethod
    public boolean edit(Metric metric) {
        return metricBean.edit(metric);
    }

    @Override
    @WebMethod
    public List<Metric> findMetrics() {
        return metricBean.findMetrics();
    }

    @Override
    @WebMethod
    public List<Metric> findMetricsLimit(int maxResults, int firstResult) {
        return metricBean.findMetrics(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public int getMetricCount() {
        return metricBean.getMetricCount();
    }

    @Override
    @WebMethod
    public long getLastesOrdersID() {
        return metricBean.getLatesOrdersID();
    }
}
