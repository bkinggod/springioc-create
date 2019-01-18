package com.itgood.springframework.beans.factory.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bicheng on 2019/1/18.
 */
public class DefaultBeanDefinition implements BeanDefinition {

    public static final String SCOPE_DEFAULT = "singleton";

    private String name;

    private String className;

    private String scope;

    private List<PropertyValue> propertyValues;

    @Override
    public String getScope() {
        if(this.scope == null){
            this.scope = SCOPE_DEFAULT;
        }
        return this.scope;
    }

    @Override
    public void setScope(String scope) {
         this.scope = scope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
          this.name = name;
    }

    @Override
    public String getClassName() {
        return this.className;
    }

    @Override
    public void setClassName(String className) {
         this.className = className;
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        if(this.propertyValues == null){
            this.propertyValues = new ArrayList<PropertyValue>();
        }
        return this.propertyValues;
    }

    @Override
    public void setPropertyValues(List<PropertyValue> propertyValues) {
         this.propertyValues = propertyValues;
    }
}
