package Path;

import java.util.Stack;

public class Path {
	public static void main(String[] args){
//		Stack<String> s = new Stack<String>();
//		s.push("a");
//		s.push("b");
//		s.push("c");
//		String[] strs = s.toArray(new String[s.size()]);
//		for(String str : strs)
//			System.out.println(str);
		String path = "/ab/c//d";
		String[] directories = path.split("/");
		for(String str : directories)
			System.out.println(str);
	}
}
