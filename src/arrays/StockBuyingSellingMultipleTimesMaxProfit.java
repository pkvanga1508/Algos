package arrays;

public class StockBuyingSellingMultipleTimesMaxProfit {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int buy = prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            }
            sell = prices[i];
            int currProfit = sell - buy;
            if(currProfit > 0) {
                maxProfit += currProfit;
                buy = prices[i];
            }
        }
        return maxProfit;
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
                        System.out.println(" Buy: " + buy + " Sell: " + sell);
                        profit += sell - buy;
                    }
                }
            } else {
                if((prices[counter] < prices[counter - 1])
                        && (prices[counter] < prices[counter  + 1])) {

                    buy = prices[counter];
                }
                if((prices[counter] > prices[counter - 1])
                        && (prices[counter] > prices[counter  + 1])) {
                    sell = prices[counter];
                    if(buy != Integer.MAX_VALUE) {
                        System.out.println(" Buy: " + buy + " Sell: " + sell);
                        profit += sell - buy;
                    }
                }

            }
        }
        return profit;
    }
}
