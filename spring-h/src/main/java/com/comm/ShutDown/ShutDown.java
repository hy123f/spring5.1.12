package com.comm.ShutDown;

public class ShutDown {
	public static void main(String[] args){
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	        System.out.println("�ر�֮ǰ��Ҫ���ŵĴ�����Դ");
	    }));
	}
}

//1. ���������˳�
//2. ʹ��System.exit()
//3. �ն�Ctrl+C
//4. ϵͳ�ر�
//5. Kill pid����ɵ����̣�����kill -9 pid��
