package com.bookAlias.alias;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean(name = {"��һ����ԭʼ����", "book", "tom", "cat"})
    public BookFactoryBean book(){
        BookFactoryBean bookFactoryBean = new BookFactoryBean();
        bookFactoryBean.setBeanInfo("����������ʵ����һЩ����bean ��ϸ�ڣ����ϲ�Ӧ�ô����˱���");
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