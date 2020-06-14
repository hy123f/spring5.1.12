package ioc.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class X {
	
	@Autowired
	public Y y;
	
	public X() {
		System.out.println("X的构造方法执行了");
	}

}
