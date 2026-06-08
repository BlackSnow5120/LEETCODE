func pivotArray(nums []int, pivot int) []int {
    arr1 := []int{}
    arr2 := []int{}
    count :=0 
    for _,i := range nums  {
        if (i<pivot) {
            arr1 = append(arr1,i)
        }else if(i==pivot){
            count++;

        }else {
                        arr2 = append(arr2,i)
        }
    }

    for i:=0;i<count;i++ {
        arr1=append(arr1,pivot)
    }
    arr1 = append(arr1,arr2...)
    return arr1
}