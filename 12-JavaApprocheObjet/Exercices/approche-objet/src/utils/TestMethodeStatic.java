package utils;

public class TestMethodeStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "12";
		int number = Integer.parseInt(str);
		System.out.println(number + " est de type integer");
		int a = 30;
		int b = 20;
		System.out.println(Integer.max(a, b));
		
		String test1 = "Coucou";
		String test2 = "Hibou";
		
		System.out.println(StringUtils.sBuilder(test1," ",test2, 10));
	}

}
