class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for (int i =0;i<n;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }else{
            mp.put(nums[i],mp.get(nums[i])+1);
            }
        }
        int[][] array = new int[mp.size()][2];
        int i = 0;
        for (Integer key: mp.keySet()){
            array[i][0] = key;
            array[i][1] = mp.get(key);
            i++;
        }
        Arrays.sort(array,(a,b) -> {
            if(a[1]<b[1]){
                return 1;
            }
            if(a[1]>b[1]){
                return -1;
            }
            return 0;
        });
        int[] ans = new int[k];
        for(int j =0;j<k;j++){
            ans[j]=array[j][0];
        }
        return ans;
    }
}