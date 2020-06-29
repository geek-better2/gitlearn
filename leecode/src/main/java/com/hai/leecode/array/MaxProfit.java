package com.hai.leecode.array;

/**
 * 剑指 Offer 63. 股票的最大利润  leecode 121题
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {

    /**
     * 暴力法,时间复杂度为O(n2)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxPro = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                maxPro = Math.max(maxPro, prices[j] - prices[i]);
            }
        }
        return maxPro;
    }

    /**
     * 动态规划,时间复杂度O(n),空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int lo = 0, hi = 0;
        int len = prices.length;
        int max = 0;
        while (hi < len) {
            int dis = prices[hi] - prices[lo];
            if (dis < 0) {
                lo = hi;
            } else if (dis > max) {
                max = dis;
            }
            hi++;
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums = {7,2,3,8,4,1,9};
        MaxProfit instance = new MaxProfit();
        int res = instance.maxProfit2(nums);
        System.out.println("最大的收益为: " + res);


    }
}
