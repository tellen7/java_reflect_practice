package wangyonghao.classUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ClassUtil {
	
	/**
	 * 打印指定对象所属类的所有公有方法
	 * @param obj
	 */
	public static void printMethodMessage(Object obj){
		//通过类的反射获取类的信息，必须获得该类的类类型
		//有三种方法获得类的类类型
		Class<?> class1 = obj.getClass();
		//获得类中所有公有方法，包括继承的公有方法
		//getDeclaredMethod()方法用于获得该类内自己声明的所有方法(公私保护)，不包括继承的
		Method[] methods = class1.getMethods();//class1.getDeclaredMethod()
		for(Method m : methods){
			//获得方法的返回类型
			Class<?> returnType = m.getReturnType();
			System.out.print(returnType.getName()+" "+m.getName()+"(");
			//获得方法的参数表中参数的类型
			Class<?>[] paraType = m.getParameterTypes();
			for(Class<?> c : paraType){
				//依次打印参数表中的参数类型
				System.out.print(c.getName()+",");
			}
			System.out.println(")");
		}
	}
	
	/**
	 * 打印指定对象所属类的所有数据成员
	 * @param obj
	 */
	public static void printFields(Object obj){
		Class<?> class1 = obj.getClass();
		//获得指定类对象的所有数据成员
		//getFields()是获得所有公有数据成员，包括继承的
		Field[] fields = class1.getDeclaredFields();
		for(Field field : fields){
			Class<?> type = field.getType();
			System.out.println(type.getName()+" "+field.getName());
		}
	}
	
	/**
	 * 打印指定对象所属类的所有构造方法
	 */
	public static void printConstructor(Object obj){
		Class<?> class1 = obj.getClass();
		//Returns an array of Constructor objects reflecting all the constructors 
		//declared by the class represented by this Class object
		Constructor<?>[] constructors = class1.getDeclaredConstructors();
		for(Constructor<?> constructor : constructors){
			System.out.print(constructor.getName()+"(");
			Class<?>[] type = constructor.getParameterTypes();
			for(Class<?> c : type){
				System.out.print(c.getName()+",");
			}
			System.out.println(")");
		}
	}
	
}
