package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("aop")
@EnableAspectJAutoProxy  /*�����Զ�Ϊƥ�� aspectJ ע��� Java �����ɴ������ */  //Ĭ��ʹ��jdk�Ķ�̬����    ����ʹ��cglib����
public class AppConfig {
}