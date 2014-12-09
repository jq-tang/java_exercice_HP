package minwindow;

public class Solution {
	public String minWindow(String S, String T) {
		if(S == null || T == null){
            return "";
        }
        int lens = S.length();
        int lent = T.length();
        int[] needtofind = new int[256];
        int[] hasfound = new int[256];
        for(int i = 0; i < lent; ++i){
            needtofind[T.charAt(i)]++;
        }
        String result = "";
        int min = lens;
        int start = 0, count = 0;
        for(int i = 0; i < lens; ++i){
            char c = S.charAt(i);
            if(needtofind[c] > 0){
                
                if(needtofind[c] > hasfound[c]){
                    count++;
                }
                hasfound[c]++;
                if(count >= lent){
                    char left = S.charAt(start);
                    while(needtofind[left] == 0 || hasfound[left] > needtofind[left]){
                    	if(hasfound[left] > needtofind[left]){
                            hasfound[left]--;
                        }
                        left = S.charAt(++start);
                    }
                }
                if(count == lent){
                    int length = i - start + 1;
                    if(min >= length){
                        min = length;
                        result = S.substring(start, i+1);
                    }
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.minWindow("bdab", "ab"));
	}
}
