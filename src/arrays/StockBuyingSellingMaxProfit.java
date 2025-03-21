package arrays;

public class StockBuyingSellingMaxProfit {

    //
    public int maxProfit(int[] prices) {

        int profit = 0;
        int buy = prices[0];

        for(int price : prices) {
            if(price < buy) {
                buy = price;
            }
            int currProfit =  price - buy;
            if(currProfit > profit) {
                profit = currProfit;
            }
        }
        return profit;
    }

    //Peaks and Valleys
    public int maxProfitPeaksAndValleys(int[] prices) {

        if(prices.length < 2) return 0;

        int profit = 0;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;

        for(int counter = 0; counter < prices.length; counter++) {

            if(counter == 0) {
                if(prices[counter + 1] < prices[counter]) continue;
                if(prices[counter + 1] > prices[counter]) {
                    buy = prices[counter];
                }
            } else if (counter == prices.length - 1) {
                if(prices[counter] < prices[counter - 1]) continue;
                if(prices[counter] > prices[counter - 1]) {
                    sell = prices[counter];
                    if(buy != Integer.MAX_VALUE) {
                        int currProfit = sell - buy;
                        if(currProfit > profit) {
                            profit = currProfit;
                        }
                    }
                }
            } else {
                if((prices[counter] <= prices[counter - 1])
                        && (prices[counter] < prices[counter  + 1])) {
                    if(prices[counter] < buy){
                        buy = prices[counter];
                    }

                }
                if((prices[counter] >= prices[counter - 1])
                        && (prices[counter] > prices[counter  + 1])) {
                    sell = prices[counter];
                    if(buy != Integer.MAX_VALUE) {
                        int currProfit = sell - buy;
                        if(currProfit > profit) {
                            profit = currProfit;
                        }
                    }
                }

            }
        }
        return profit;
    }
}
