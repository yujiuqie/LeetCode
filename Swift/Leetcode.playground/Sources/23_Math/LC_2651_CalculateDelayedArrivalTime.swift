class Solution_2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}

public class LC_2651_CalculateDelayedArrivalTime : Solution_2651 {
    public override init() {}
}