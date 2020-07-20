package com.comm.ShutDown;

public class ShutDown {
	public static void main(String[] args){
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	        System.out.println("关闭之前我要优雅的处理资源");
	    }));
	}
}

//1. 程序正常退出
//2. 使用System.exit()
//3. 终端Ctrl+C
//4. 系统关闭
//5. Kill pid命令干掉进程（不是kill -9 pid）
