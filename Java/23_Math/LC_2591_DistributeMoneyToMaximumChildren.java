class Solution {
    public int distMoney(int money, int children) {

        if (money < children) {
            return -1;
        }

        if (8 * (children - 1) + 4 == money) {
            return children - 2;
        }

        if (money > children * 8) {
            return children - 1;
        }

        return (money - children) / 7;
    }
}

public class LC_2591_DistributeMoneyToMaximumChildren {

}
