func rev(nums *[]int,i int,j int){
    for i<j {
        temp := (*nums)[i]
        (*nums)[i]=(*nums)[j]
        (*nums)[j]=temp
        i++
        j--
    }
}
func rotate(nums []int, k int)  {
    r := k % len(nums)
    size := len(nums)
    rev(&nums,size-r,size-1)
    rev(&nums,0,size-1)
    rev(&nums,r,size-1)


}