package leetcode;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 * See examples in corresponding test class 'FruitIntoBaskets904Test'.
 */
public class FruitIntoBaskets904 {
    public int totalFruit(int[] tree) {
        int n = tree.length;
        if (n <= 1) return n;
        Basket prevBasket = null;
        Basket curBasket = new Basket(tree[n - 1], 1);
        int maxFruits = 1;
        int sameBasketCount = 1;
        for (int i = n - 2; i >= 0; i--) {
            int sum;
            if (prevBasket == null) {
                if (tree[i] != curBasket.type) {
                    prevBasket = curBasket;
                    curBasket = new Basket(tree[i], 1);
                    sameBasketCount = 1;
                } else {
                    curBasket.fruits++;
                    sameBasketCount++;
                }
                sum = curBasket.fruits + (prevBasket == null ? 0 : prevBasket.fruits);
            } else {
                if (tree[i] != curBasket.type && tree[i] != prevBasket.type) {
                    prevBasket = curBasket;
                    prevBasket.fruits = sameBasketCount;
                    curBasket = new Basket(tree[i], 1);
                    sameBasketCount = 1;
                } else if (tree[i] == curBasket.type) {
                    sameBasketCount++;
                    curBasket.fruits++;
                } else { // tree[i] == prevBasket.type
                    Basket tmp = prevBasket;
                    prevBasket = curBasket;
                    curBasket = tmp;
                    curBasket.fruits++;
                    sameBasketCount = 1;
                }
                sum = curBasket.fruits + prevBasket.fruits;
            }
            if (sum > maxFruits) {
                maxFruits = sum;
            }
        }
        return maxFruits;
    }

    private static class Basket {
        int type;
        int fruits;

        Basket(int type, int fruits) {
            this.type = type;
            this.fruits = fruits;
        }
    }
}
