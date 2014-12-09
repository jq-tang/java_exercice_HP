package reg;

public class Solution {
	 public boolean isMatch(String s, String p) {
	        boolean []  previousLevel = new boolean[p.length()+1];
	        previousLevel[0] = true;
	        
	        
	        //Initialization
	        for (int i=0; i<p.length(); i++)
	            if(p.charAt(i)=='*')
	                previousLevel[i+1]= previousLevel[i-1];
	        
	        for (int letter=0; letter<s.length(); letter++)
	        {
	            boolean []  thisLevel = new boolean[p.length()+1];
	            for (int i=0; i<p.length(); i++)
	            {
	                if(p.charAt(i)=='.' || p.charAt(i)==s.charAt(letter))
	                    thisLevel[i+1]= previousLevel[i];
	                if(p.charAt(i)=='*')
	                {
	                    thisLevel[i+1] = thisLevel[i-1];
	                    thisLevel[i+1] = thisLevel[i+1] || ( previousLevel[i+1] && (p.charAt(i-1)==s.charAt(letter)|| p.charAt(i-1)=='.'));
	                }
	            }
	            previousLevel = thisLevel;
	        }
	        return previousLevel[p.length()];
	    }
	 
	 public static void main(String[] args) {
		 Solution s = new Solution();
		 s.isMatch("aaa", "a*");
	 }
}
