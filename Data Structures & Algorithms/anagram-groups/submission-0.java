class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] st = strs[i].toCharArray();
            Arrays.sort(st);
            String sts = new String(st);
            if(!map.containsKey(sts)){
                map.put(sts, new ArrayList<>());
            }
            map.get(sts).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}