import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen=new HashSet<>();
        int l=0;
        int ans=0;
        for(int r=0;r<s.length();r++){
            while(seen.contains(s.charAt(r))){
                
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            ans=Math.max(r-l+1,ans);
        }
        return ans;
    }
} {
    
}
