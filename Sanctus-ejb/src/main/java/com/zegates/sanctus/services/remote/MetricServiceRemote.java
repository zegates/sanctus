package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Metric;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MetricServiceRemote {
    @WebMethod
    boolean createMetric(Metric metric);
    @WebMethod
    boolean edit(Metric metric);
    @WebMethod
    List<Metric> findMetrics();
    @WebMethod
    List<Metric> findMetricsLimit(int maxResults, int firstResult);
    @WebMethod
    int getMetricCount();
    @WebMethod
    long getLastesOrdersID();
}
