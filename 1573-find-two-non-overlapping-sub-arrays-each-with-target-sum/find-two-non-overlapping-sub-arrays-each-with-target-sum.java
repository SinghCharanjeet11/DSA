class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int answer = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // Carry forward the best answer from previous index
            if (i > 0) {
                best[i] = best[i - 1];
            }

            // Check if a subarray ending at i has sum = target
            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target);
                int length = i - start;

                // Need a previous non-overlapping subarray
                if (start >= 0 && best[start] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, length + best[start]);
                }

                // This subarray can become the best one for future indices
                minLength = Math.min(minLength, length);
                best[i] = Math.min(best[i], minLength);
            }

            map.put(prefixSum, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}