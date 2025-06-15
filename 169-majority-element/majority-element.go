func majorityElement(nums []int) int {
    mp := make(map[int]int)
    max :=0
    ans := -1;
    for _,n:= range(nums){
        mp[n]++
        if mp[n]>max{
            max = mp[n];
            ans=n;
        }
    }
    return ans;
}