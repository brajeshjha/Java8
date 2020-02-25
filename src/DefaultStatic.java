/*
 * default and static method can not be overridden if only in one interface,but,
 * if class implements two interface and both interface have same default method
 * then one interface method must be overridden(using @Override),
 * then whichever method is overridden is called
 * class method has preference over interface(Third rule)
 */
interface A{
	default void m1(){
		System.out.println("A-m1");
	}
}

interface B{
	default void m1(){
		System.out.println("B-m1");
	}
}

interface C{
	static void m1(){
		System.out.println("C-m1");
	}
}

class D{
	public void m1(){
		System.out.println("C-m1");
	}
}

class X extends D implements A,B,C{
	
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		A.super.m1();
	}
}
public class DefaultStatic {
	public static void main(String[] args){
		X x=new X();
		x.m1();
		C.m1();
	}
}
