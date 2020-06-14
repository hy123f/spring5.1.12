package design.d;

import java.util.Date;

import design.c.FrameworkServle;

public class DispatcherServle extends FrameworkServle{

	
	
	public static void main(String[] args) {
		DispatcherServle dispatcherServle = new DispatcherServle();
		dispatcherServle.doPost();
		
		System.out.println(new Date().getTime());
	}

	@Override
	protected void doService(){
		System.out.println(" DispatcherServle doService");
	}
}
