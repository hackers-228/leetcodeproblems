class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, 
                                               int[] healths, 
                                               String directions) {
        int n = positions.length;

        // Step 1: Create index array to sort by position
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        // Sort indices by their position value
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

        // Step 2: Stack stores ORIGINAL indices of right-moving robots
        Stack<Integer> stack = new Stack<>();

        // Step 3: Process robots in position order
        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                // Moving right → push, may collide with future L robot
                stack.push(idx);
            } else {
                // Moving left → fight with all R robots in stack
                while (!stack.isEmpty()) {
                    int topIdx = stack.peek();  // Top R robot

                    if (healths[topIdx] > healths[idx]) {
                        // R wins → R health-1, L dies
                        healths[topIdx]--;
                        healths[idx] = 0;       // Mark L as dead
                        break;

                    } else if (healths[topIdx] < healths[idx]) {
                        // L wins → L health-1, R dies
                        healths[idx]--;
                        healths[topIdx] = 0;    // Mark R as dead
                        stack.pop();
                        // L continues fighting next R robot!

                    } else {
                        // Equal health → both die
                        healths[topIdx] = 0;
                        healths[idx] = 0;
                        stack.pop();
                        break;
                    }
                }
            }
        }

        // Step 4: Collect survivors in ORIGINAL order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}