package tagzy;

public class DaxiaoXieTag {
	public static String dx(String dd) {
		StringBuilder sb=new StringBuilder();
		for(char c:dd.toCharArray()) {
			if(Character.isUpperCase(c)) {
				sb.append(Character.toLowerCase(c));
			}else if(Character.isLowerCase(c)) {
				sb.append(Character.toUpperCase(c));
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
