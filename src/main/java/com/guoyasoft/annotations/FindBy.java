package com.guoyasoft.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 1. 允许子类继承父类的注解
 */
@Inherited
/*
 * 2. 该注解可以用在什么元素上：Field表示字段；可以指定多个作用对象，如可以同时用到类名、字段和方法上，多个用数组表示{,}
 */
@Target(ElementType.FIELD)
/*
 * 3. 注解保留到哪个阶段：源代码开发SOURCE、编译期（CLASS）、运行期（RUNTIME）
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * 4. 注解的类型：@interface，java的其它几种类型为：class、abstract class、interface
 */
public @interface FindBy {
	/*
	 *5. 定义获取参数的方法，定义后，注解可以带同名参数，并通过注解的该方法获取参数的值 
	 *
	 *如：使用注解
	 *@FindBy(xpath="")
	 *WebElement element;
	 *
	 *获取注解的值
	 *Annotation a=field.getAnnotation(FindBy.class);
	 *String value=a.xpath();
	 */
	String id() default "";
	String name() default "";
	String xpath() default "";
	String linkText() default "";
	String partitialLinkText() default "";	
}
