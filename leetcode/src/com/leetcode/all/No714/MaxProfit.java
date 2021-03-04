package com.leetcode.all.No714;

/**
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例：
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 注意：
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class MaxProfit {
    /**
     * 贪心算法
     * 当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
     * 在遍历完整个数组 prices 之后之后，我们就得到了最大的总收益。
     * <p>
     * <p>
     * 我们用 buy 表示在最大化收益的前提下，如果我们手上拥有一支股票，那么它的最低买入价格是多少。
     * 在初始时，buy 的值为 prices[0] 加上手续费 fee。那么当我们遍历到第 i(i>0) 天时：
     * 如果当前的股票价格 prices[i] 加上手续费 fee 小于 buy，那么与其使用 buy 的价格购买股票，
     * 我们不如以 prices[i]+fee 的价格购买股票，因此我们将 buy 更新为 prices[i]+fee；（相当于前一天不适合购买，换到当前来购买，实际上就是选择价格最低的一天来购买）
     * <p>
     * 如果当前的股票价格 prices[i] 大于 buy，那么我们直接卖出股票并且获得 prices[i]−buy 的收益。
     * 但实际上，我们此时卖出股票可能并不是全局最优的（例如下一天股票价格继续上升），因此我们可以提供一个反悔操作，
     * 看成当前手上拥有一支买入价格为 prices[i] 的股票，将 buy 更新为 prices[i]。这样一来，如果下一天股票价格继续上升，
     * 我们会获得 prices[i+1]−prices[i] 的收益，加上这一天 prices[i]−buy 的收益，恰好就等于在这一天不进行任何操作，
     * 而在下一天卖出股票的收益；
     * <p>
     * 对于其余的情况，prices[i] 落在区间 [buy−fee,buy] 内，它的价格没有低到我们放弃手上的股票去选择它，
     * 也没有高到我们可以通过卖出获得收益，因此我们不进行任何操作。
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int buy = prices[0] + fee;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                totalProfit += prices[i] - buy;
                buy = prices[i];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = maxProfit.maxProfit(prices, fee);
        System.out.println(result);
    }
}
