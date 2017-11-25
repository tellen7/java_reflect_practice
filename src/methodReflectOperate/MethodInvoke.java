package methodReflectOperate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoke {
public static void main(String[] args) {
	A a1 = new A();
	//获得a1的类类型
	Class<?> class1 = a1.getClass();
	//获得指定方法print(int,int)
	try {
		//a1.print(10,20);
		//Method m1 = class1.getMethod("print", new Class<?>[]{int.class,int.class});
		Method m1 = class1.getMethod("print", int.class,int.class);
		//用方法“调用对象”
		//m1.invoke(a1, 10,20);
		m1.invoke(a1, new Object[]{10,20});
		System.out.println("==========================");
		//获得类自己定义的方法
		Method m2 = class1.getDeclaredMethod("print", new Class[]{String.class,String.class});
		//Method m2 = class1.getDeclaredMethod("print",String.class,String.class);
		m2.invoke(a1, "Hello","worLD");
		System.out.println("==========================");
		
		
		//Method m3 = class1.getMethod("print");
		Method m3 = class1.getMethod("print", new Class[]{});
		m3.invoke(a1);
		
		
		
		
	} catch (SecurityException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
class A{
	public void print(){
		System.out.println("helloworld");
	}
	public void print(int a,int b){
		System.out.println(a+b);
	}
	public void print(String a,String b){
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}