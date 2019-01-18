package com.itgood.test;

import com.itgood.entities.Children;
import com.itgood.entities.Persion;
import com.itgood.springframework.beans.factory.BeanFactory;
import com.itgood.springframework.beans.factory.xml.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by bicheng on 2019/1/18.
 */
public class UnitTest {

    @Test
    public void testOne(){
        // "classpath: applicationContext.xml"
        BeanFactory context =new ClassPathXmlApplicationContext("/applicationContext.xml");
        Children children = (Children) context.getBean("children");
        System.out.println(children);

       Persion persion = (Persion) context.getBean("persion");
       System.out.println(persion);

    }
}
