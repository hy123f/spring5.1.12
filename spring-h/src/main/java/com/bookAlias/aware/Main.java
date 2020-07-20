package com.bookAlias.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
    	AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
        
        app.close();
    }
}