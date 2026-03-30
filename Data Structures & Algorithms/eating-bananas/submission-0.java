class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right =0;
        for(int pile : piles){
            right = Math.max(right,pile);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            int totaltime =0;
            for(int pile : piles){
                totaltime += Math.ceil((double)pile/mid);
            }
            if(totaltime <= h){
                right = mid;
            }else {
                left = mid+1;
        }
            
            
        }
        return left;

    }
}
