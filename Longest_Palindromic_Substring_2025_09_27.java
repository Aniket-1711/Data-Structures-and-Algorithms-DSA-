class Solution {
    public String longestPalindrome(String s) {
        int ans=0,start=0, end=0, len1=0,len2=0,len=0;
        for(int i=0;i<s.length();i++){
            len1 = gLL(s, i, i);
            len2= gLL(s, i, i+1);
            len=Math.max(len1, len2);
            if (len > end - start) {  // found a longer palindrome
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);  
    }
    public int gLL(String str,int p1, int p2){
        while(p1>=0 && p2<str.length() && str.charAt(p1)==str.charAt(p2)){
            p1--;
            p2++;
        }
        return p2-p1-1;
    }
}
