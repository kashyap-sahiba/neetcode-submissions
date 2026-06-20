class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
           map.put(num,map.getOrDefault(num,0)+1);
        }

        int[] topK = map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                        .limit(k)
                        .mapToInt(Map.Entry::getKey)
                        .toArray();

        return topK;

    }
}
