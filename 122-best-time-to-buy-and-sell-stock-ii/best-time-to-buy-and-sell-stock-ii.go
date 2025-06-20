func maxProfit(prices []int) int {
    low := prices[0]
    ans := 0

    for i := 1 ; i< len(prices);i++{

        if(prices[i] < prices[i-1]){
        ans = ans + prices[i-1] - low
        low = prices[i];
        
        }
    }
    last := prices[len(prices)-1]
    if(low<last){
        ans = ans + last - low
    }
    return ans
}