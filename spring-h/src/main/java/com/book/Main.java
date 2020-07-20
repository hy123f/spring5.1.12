package com.book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        Book book = context.getBean(Book.class);
        System.out.println(book);
        
        context.close();
    }

}
