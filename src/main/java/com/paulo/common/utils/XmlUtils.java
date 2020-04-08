package com.paulo.common.utils;

import com.google.common.collect.Lists;
import com.paulo.common.annotation.XmlAttr;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;


import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * xml解析帮助类
 * Create by tfy on 2020/3/7 13:24
 **/
public class XmlUtils {
    /**
     * 获取根节点
     */
    private static Element getRoot(String xml) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);

        return document.getRootElement();
    }

    /**
     * 解析xml
     */
    public static List<Object> extractXml(String xml, Class type, String nodeName) throws DocumentException, IllegalAccessException, InstantiationException {
        Element root = getRoot(xml);
        List<Object> ret = Lists.newArrayList();
        getObjList(root, ret, type, nodeName);
        return ret;
    }

    /**
     * 属性解析
     */
    private static void getObjList(Element root, List<Object> list, Class type, String elementName) throws InstantiationException, IllegalAccessException {
        String rootName = root.getName().trim();
        if (rootName.toLowerCase().equals(elementName.toLowerCase())) {
            List<Attribute> attributes = root.attributes();
            Object obj = buildObj(type, attributes);
            if (!Objects.isNull(obj)) {
                list.add(obj);
            }
        }

        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            getObjList(element, list, type, elementName);
        }
    }

    /**
     * 构建对象
     */
    private static Object buildObj(Class type, List<Attribute> attributes) throws IllegalAccessException, InstantiationException {
        Field[] fields = type.getDeclaredFields();
        Object o = type.newInstance();
        for (Attribute attribute : attributes) {
            for (Field field : fields) {
                String filedName;
                XmlAttr annotation = field.getAnnotation(XmlAttr.class);
                filedName = Objects.isNull(annotation) ? field.getName() : annotation.value();
                String attributeName = attribute.getName();
                if (filedName.toLowerCase().equals(attributeName.toLowerCase())) {
                    field.setAccessible(true);
                    field.set(o, attribute.getValue());
                    break;
                }
            }
        }
        return o;
    }
}
