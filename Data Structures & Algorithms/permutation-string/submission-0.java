class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int []freq = new int [26];
        for(int i =0; i< s1.length(); i++){
           // int idx = s1[i] - 'a';
            freq[s1.charAt(i)-'a']++;
        }
        int windsize = s1.length();
        for(int i =0; i <s2.length(); i++){
            int windidx =0;
            int idx =i;

            int []windfreq = new int[26];
            while(windidx < windsize && idx < s2.length()){
                windfreq[s2.charAt(idx) - 'a']++;
                windidx++;
                idx++;
            }
            if(isFreqsame(freq,windfreq)){
                return true;
            }
        }
        return false;
    }
    public boolean isFreqsame(int freq1[], int freq2[]){
        for(int i =0; i < 26; i++){
            if (freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}
