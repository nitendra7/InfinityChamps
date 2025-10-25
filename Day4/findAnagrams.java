class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> al=new ArrayList<>();

        int[] freq=new int[26];
        int pl=p.length(),tl=s.length(),c=0;
        if(pl>tl) return new ArrayList<>();
        char[] str=s.toCharArray();
        for(int i=0;i<pl;i++){
            freq[str[i]-'a']++;
            freq[p.charAt(i)-'a']--;
        }
        boolean flag=true;
        for(int f:freq){
            if(f!=0){
                c=0;
                flag=false;
                break;
            }   
        }
        if(flag) al.add(0);
        for(int i=pl;i<str.length;i++){
            if(isAnagram(str,pl,freq,i)){
                al.add(i-pl+1);
            }
        }
        return al;
    }

    public boolean isAnagram(char[] str,int len,int[] freq,int i){
        freq[str[i]-'a']++;
        freq[str[i-len]-'a']--;
        for(int f:freq){
            if(f!=0){
                return false;
            }
        }
        return true;
    }
}