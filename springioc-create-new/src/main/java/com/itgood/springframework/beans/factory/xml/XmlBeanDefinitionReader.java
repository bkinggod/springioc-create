package com.itgood.springframework.beans.factory.xml;

import com.itgood.springframework.beans.factory.config.BeanDefinition;
import com.itgood.springframework.beans.factory.config.DefaultBeanDefinition;
import com.itgood.springframework.beans.factory.config.PropertyValue;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bicheng on 2019/1/18.
 */
public class XmlBeanDefinitionReader {

    private static Map<String,BeanDefinition> map = new HashMap<String, BeanDefinition>();

    public static Map<String, BeanDefinition> getConfig(String path){

        //1.创建解析器
        SAXReader reader = new SAXReader();
        //2.加载配置文件,得到document对象
        InputStream is = XmlBeanDefinitionReader.class.getResourceAsStream(path);
        Document doc =null;
        try {
            doc = reader.read(is);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查您的xml配置是否正确");
        }
        // 3.定义xpath表达式,取出所有Bean元素
        String xpath="//bean";

        //4.对Bean元素继续遍历
        List<Element> list = doc.selectNodes(xpath);

        if(list!=null){
            //4.1将Bean元素的name/class属性封装到bean类属性中

            // 4.3将属性name/value/ref分装到类Property类中

            for (Element bean : list) {
                BeanDefinition b = new DefaultBeanDefinition();
                String name=bean.attributeValue("name");
                String clazz=bean.attributeValue("class");
                String scope=bean.attributeValue("scope");
                b.setName(name);
                b.setClassName(clazz);
                if(scope!=null){
                    b.setScope(scope);
                }
                //  4.2获得bean下的所有property子元素
                List<Element> children = bean.elements("property");

                // 4.3将属性name/value/ref分装到类Property类中
                if(children!=null){
                    for (Element child : children) {
                        PropertyValue prop=new PropertyValue();
                        String pName=child.attributeValue("name");
                        String pValue=child.attributeValue("value");
                        String pRef=child.attributeValue("ref");
                        prop.setName(pName);
                        prop.setRef(pRef);
                        prop.setValue(pValue);
                        // 5.将property对象封装到bean对象中
                        b.getPropertyValues().add(prop);
                    }
                }
                //6.将bean对象封装到Map集合中,返回map
                map.put(name, b);
            }
        }
        return map;
    }
}
