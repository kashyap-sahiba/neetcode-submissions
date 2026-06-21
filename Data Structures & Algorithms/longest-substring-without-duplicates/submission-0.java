class Solution {
    public int lengthOfLongestSubstring(String s) {
    int maxLen = 0;
    for(int i =0; i < s.length(); i++){
        for(int j=i+1;j<=s.length();j++){
            if(allUnique(s,i,j)){
                maxLen = Math.max(maxLen,j-i);
            }
        }
    }
    return maxLen;
    }

    private boolean allUnique(String s, int start, int end){
        Set<Character> seen = new HashSet<>();

        for(int i =start;i<end;i++){
            if(seen.contains(s.charAt(i))) return false;
            seen.add(s.charAt(i));
        }

        return true;
    }
}
