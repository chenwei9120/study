package com.bit.filter;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName NoConfigFilter.java
 * @Description TODO
 * @createTime 2019年12月12日 13:44:00
 */
@Component
public class NoConfigFilter extends TypeExcludeFilter {


    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if("com.bit.controlloer.NoConfigController".equals(metadataReader.getClassMetadata().getClassName())){
            return true;
        }
        return false;
    }
}