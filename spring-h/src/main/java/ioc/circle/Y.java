package ioc.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Y {
	
	@Autowired
	public X x;
	
	public Y() {
		System.out.println("Y的构造方法执行了");
	}

}
