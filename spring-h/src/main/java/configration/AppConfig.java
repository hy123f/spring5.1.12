package configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//�������ע����û��ʲô���õġ�
@Configuration   //Ϊ��ȷ��@Bean�Ķ����ǵ�����            ���������һ��������󡣿���ȥ�޸�����ķ�����   full��site
//@ComponentScan("configration")
public class AppConfig {
	
	@Bean
	public Y y() {
		return new Y();
	}
	
	@Bean
	public Z z() {
		y();  //ʵ��y�Ĺ��췽��ֻ��ִ��һ�顣
		return new Z();
	}

}//���忴�߼��������Ǿ�����߼���   processon.com  ��ͼ������
//AppConfigʲôʱ�򱻴���
//AppConfig�������Ҫ��ʵ�����ģ�--bean--proxy object
//      ����һ����--proxy  class
//           �����������ô����
//                 spring����θ���һ��������������----���ʱ���Ѿ���һ�������ࡣ


//spring3.0�Ժ󣬲�֧��ͨ���ӿ�ע�룬   ����ƽʱ�ģ���ͨ������ע�롣
//����ֻ֧�ֹ��췽����bytype��byname��

//mybatis��mappscan��չ��spring��ע�⡣��