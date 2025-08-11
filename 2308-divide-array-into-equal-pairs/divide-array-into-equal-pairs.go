func divideArray(nums []int) bool {
    mp := make(map[int]int)
    for _,i := range nums{
        mp[i]++
    }
    for _,v := range mp {
        if v%2!=0{
            return false
        }
    }
    return true
}