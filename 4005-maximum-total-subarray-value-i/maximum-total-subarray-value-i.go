func maxTotalValue(nums []int, k int) int64 {
    max:= nums[0]
    min:=nums[0]
    for _,i := range(nums){
        if(i<min){
            min=i
        }
        if(i>max){
            max = i
        }
    }
    return (int64)((max-min)*k);
}