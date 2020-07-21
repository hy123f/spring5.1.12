package aop;

import org.springframework.stereotype.Component;

@Component
public class AopObject {

    public int aoped(){
        System.out.println("logic");
        return 1;
    }
}

