package design.c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import design.a.HttpServle;

public abstract class FrameworkServle extends HttpServle{

	@Override //此处是一个覆盖。  父类的方法根本就没有执行了。
	public void doPost() {
//		super();
		System.out.println("HttpServle doPost");
		
		doService();
	}
	
	
	protected abstract void doService();
			
}
