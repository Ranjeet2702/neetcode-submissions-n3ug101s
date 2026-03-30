class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //ArrayList<Integer>arr = new ArrayList<>();

        PriorityQueue<Integer>Queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()){
            Queue.add(key);
        }
        int[] newnum = new int[k];
        int j = 0;
        while(j < k){
            newnum[j]=Queue.poll();
            j++;
            

        }
        return newnum;
    }
}
