package com.itgood.springframework.beans.factory;

/**
 * Created by bicheng on 2019/1/18.
 */
public interface BeanFactory {

    /**
     * 核心方法
     * @return
     */
    Object getBean(String name);
}
