package design.c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import design.a.HttpServle;

public abstract class FrameworkServle extends HttpServle{

	@Override //�˴���һ�����ǡ�  ����ķ���������û��ִ���ˡ�
	public void doPost() {
//		super();
		System.out.println("HttpServle doPost");
		
		doService();
	}
	
	
	protected abstract void doService();
			
}
