class Solution {
    public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int num : nums) {
        if (num <= first) {
            first = num; // smallest
        } else if (num <= second) {
            second = num; // second smallest
        } else {
            return true; // num > first && num > second
        }
    }

    return false;
}
}