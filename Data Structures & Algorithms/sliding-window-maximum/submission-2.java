class Solution {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        //max heap
        public int compareTo(Pair P2){
            return P2.val - this.val;  // descending
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];

        PriorityQueue<Pair>pq = new PriorityQueue<>();

        // 1st window
        for(int i =0; i < k; i++){
            pq.add(new Pair(nums[i],i));
        }
        res[0] = pq.peek().val;
        int idx = 1;

        // remaining windows
        for(int i = k; i <nums.length; i++){
            while(!pq.isEmpty() && pq.peek().idx <= i-k){
                pq.remove();
            }
            pq.add(new Pair(nums[i],i));
            res[idx++] = pq.peek().val;
        }
        return res;
        

        
    }
}
