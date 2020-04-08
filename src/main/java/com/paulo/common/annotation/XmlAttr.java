package com.paulo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by tfy on 2020/3/10 13:31
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XmlAttr {
    /**
     * 属性名称
     *
     * @return
     * @author Lynch
     */
    String value() default "";
}
