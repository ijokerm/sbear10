class Outer{
	private static String msg="hello world";
	static class Inner{
		public void print(){
			System.out.println(msg);
		}
	}	
		public void fun(){
			Inner in=new Inner();
			in.print();
		}
	}

public class Text1{
	public static void main(String[] args){
		Outer.Inner in=new Outer.Inner();
		in.print();
	}
}