class Solution {
    public int countComponents(int n, int[][] edges) {
       // step 1 Build adjaceny list
       List<List<Integer>>graph = new ArrayList<>();
       for(int i =0; i< n; i++){
        graph.add(new ArrayList<>());
       }
       for(int[] edge : edges){
        int u = edge[0];
        int v = edge[1];
        graph.get(u).add(v);
        graph.get(v).add(u);
       }
       //  step2  visited array
       boolean[] vis = new boolean[n];
       int count =0;
       // traverse all nodes
       for(int i =0; i<n; i++){
            if(!vis[i]){
                dfsutil(graph,i,vis);
                count++;
            }
       }
       return count;
        
        
    }
    public void dfsutil(List<List<Integer>>graph,int start, boolean[] vis){
        Stack<Integer>stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int current = stack.pop();
            vis[current] = true;
            for(int neighbour: graph.get(current)){
                if(!vis[neighbour]){
                    stack.push(neighbour);
                }

            }
        }
    }
                    
        
    

}
