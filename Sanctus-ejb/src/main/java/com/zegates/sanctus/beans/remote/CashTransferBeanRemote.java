package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.CashTransfer;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface CashTransferBeanRemote {
    boolean create(CashTransfer cashTransfer);

    void edit(CashTransfer cashTransfer);

    void destroy(Long id);

    List<CashTransfer> findCashTransferEntities();

    List<CashTransfer> findCashTransferEntities(int maxResults, int firstResult);

    CashTransfer findCashTransfer(Long id);

    int getCashTransferCount();
}
