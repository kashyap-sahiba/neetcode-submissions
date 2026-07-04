class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for(int i =0; i <s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for(int i=0; i < 26; i++){
            if(s1Count[i]==windowCount[i]) matches++;
        }

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++){
            if(matches==26) return true;

            int rightChar = s2.charAt(right) - 'a';
            if(windowCount[rightChar] == s1Count[rightChar])
                matches--;

            windowCount[rightChar]++;

            if(windowCount[rightChar] == s1Count[rightChar]) matches++;

            int leftChar = s2.charAt(left)-'a';

            if(windowCount[leftChar] == s1Count[leftChar]) matches--;

            windowCount[leftChar]--;

            if(windowCount[leftChar] == s1Count[leftChar]) matches++;

            left++;
        }

        return matches==26;
    }
}
