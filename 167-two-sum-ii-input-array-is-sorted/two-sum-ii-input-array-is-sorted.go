func twoSum(numbers []int, target int) []int {
    mp := make(map[int]int)
    ans1:=0
    ans2:=0
    for i:=0;i<len(numbers);i++{
        if(mp[target - numbers[i]]!=0){
            ans1=mp[target - numbers[i]]
            ans2=i+1
        }
        mp[numbers[i]] = i+1
    }
    return []int{ans1,ans2}
}