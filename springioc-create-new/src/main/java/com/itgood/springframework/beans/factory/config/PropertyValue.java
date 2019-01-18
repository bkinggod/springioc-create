package com.itgood.springframework.beans.factory.config;

/**
 * Created by bicheng on 2019/1/18.
 */
public class PropertyValue {

    private String name;

    private String value;

    private String ref;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
