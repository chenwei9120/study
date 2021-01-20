package com.example.springbootdemo.datasource;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DynamicDataSource.java
 * @Description TODO
 * @createTime 2019年11月06日 14:26:00
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}