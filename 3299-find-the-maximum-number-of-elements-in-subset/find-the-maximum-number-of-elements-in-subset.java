class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }else{
                mp.put(nums[i],1);
            }
        }
        int result = 1;
        if(mp.getOrDefault(1,0)>1){
            if(mp.getOrDefault(1,0)%2==0){
                result = mp.get(1)-1;
            }else{
                result = mp.get(1);
            }
        }
        for(int i =0;i<nums.length;i++){
            int ans=0;
            int next = nums[i];
            if(next==1){
                continue;
            }
            while(mp.getOrDefault(next,0)>=2){
                ans+=2;
                next = next*next;
            }
            if(mp.getOrDefault(next,0)==1){
                ans+=1;
            }else{
                ans-=1;
            }
            result = Math.max(result,ans);
            
        }
        return result;
    }
}