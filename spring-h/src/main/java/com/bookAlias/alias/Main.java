package com.bookAlias.alias;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        Book book = context.getBean(Book.class);
        BookFactoryBean bean = (BookFactoryBean)context.getBean("&&&book");//这个可以获取到FactoryBean
//        Object bean1 = context.getBean("第一个是原始名称");
//        Object bean2 = context.getBean("cat");
//        
//        bean.setBeanInfo("BeanInfo");
//        System.out.println(bean.getBeanInfo());
        System.out.println(book);
        System.out.println(bean);
//        System.out.println(bean1);
//        System.out.println(bean2);
    }

}