package utils;

public class StringUtils {
	
	public static StringBuilder sBuilder(Object...obj) {
		
		StringBuilder builder = new StringBuilder();
		
		for(Object o : obj) {
			builder.append(o);
		}
		
		return builder;
	}
}
