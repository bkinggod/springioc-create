package com.itgood.springframework.beans.factory.config;

import java.util.List;

/**
 * Created by bicheng on 2019/1/18.
 */
public interface BeanDefinition {

    String getScope();

    void setScope(String scope);

    String getName();

    void setName(String name);

    String getClassName();

    void setClassName(String className);

    List<PropertyValue> getPropertyValues();

    void setPropertyValues(List<PropertyValue> propertyValues);

}
