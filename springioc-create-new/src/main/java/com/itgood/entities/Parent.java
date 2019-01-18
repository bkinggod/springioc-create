package com.itgood.entities;

/**
 * Created by bicheng on 2019/1/18.
 */
public class Parent {

    private Children children;

    private Parent parent;

    private String name;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
