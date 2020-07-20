package com.bookAlias.alias;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean(name = {"第一个是原始名称", "book", "tom", "cat"})
    public BookFactoryBean book(){
        BookFactoryBean bookFactoryBean = new BookFactoryBean();
        bookFactoryBean.setBeanInfo("它们隐藏了实例化一些复杂bean 的细节，给上层应用带来了便利");
        return bookFactoryBean;
    }
    
}

class BookFactoryBean implements FactoryBean<Book>{

    private String beanInfo;

    @Override
    public Book getObject() throws Exception {
        return new Book("AAA");
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    public String getBeanInfo() {
        return beanInfo;
    }

    public void setBeanInfo(String beanInfo) {
        this.beanInfo = beanInfo;
    }
}