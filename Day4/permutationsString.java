class Solution {
    public static boolean check(int[] hash){
        for(int i=0;i<26;i++){
            if(hash[i]!=0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1>len2) return false;

        int hash[]=new int[26];
        for(int i=0;i<len1;i++){
            hash[s1.charAt(i)-'a']++;
            hash[s2.charAt(i)-'a']--;
        }
        if(check(hash)){
            return true;
        }

        for(int i=len1;i<len2;i++){
            hash[s2.charAt(i)-'a']--;
            hash[s2.charAt(i-len1)-'a']++;
            if(check(hash)) return true;
        }
        return false;
    }
}