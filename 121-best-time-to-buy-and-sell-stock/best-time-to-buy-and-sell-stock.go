func maxProfit(prices []int) int {
    low := 10000
    ans := 0

    for _,num := range(prices){

        if(num < low){
        low = num;
        }

        if(num - low > ans){
            ans = num - low
        }
    }
    return ans
}