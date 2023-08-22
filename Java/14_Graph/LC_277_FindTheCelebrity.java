/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {

    int numOfPeople;

    public int findCelebrity(int n) {
        numOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {

            // 被认识的那个人，可能是候选人
            // 认识别人的人，一定不是候选人
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }

            // 一次判断获得结果
            if (isCelebrity(celebrityCandidate)) {
                return celebrityCandidate;
            }
        }

        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numOfPeople; j++) {
            if (i == j) {
                continue; // 自己认识自己就不用询问
            }

            // 如果 i 认识 j(i 认识其他人)，或 j 不认识 i(i 有没被认识的人)
            // 则 i 不是名人
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }

        return true;
    }
}