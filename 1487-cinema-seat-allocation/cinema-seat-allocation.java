class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;

            HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();


//        This will initialize the Hashmap with row and all the elements of the row in the hashset..
            for (int[] i : reservedSeats) {
                int row = i[0];
                int col = i[1];

                hm.putIfAbsent(row, new HashSet<>());
                hm.get(row).add(col);
            }
            count += (n - hm.size()) * 2;
            for (HashSet<Integer> entry : hm.values()) {
                boolean first = true;
                boolean second = true;
                boolean third = true;
                for (int seat = 2; seat <= 5; seat++) {
                    if (entry.contains(seat)) {
                        first = false;
                        break;
                    }
                }
                for (int seat = 4; seat <= 7; seat++) {
                    if (entry.contains(seat)) {
                        second = false;
                        break;
                    }
                }
                for (int seat = 6; seat <= 9; seat++) {
                    if (entry.contains(seat)) {
                        third = false;
                        break;
                    }
                }
// If there are no reserved seats or the seats reserved in a row is at 1 or 10, then that row can have 2 groups..
                if (first && third) {
                    count += 2;
                }
                else if (first || second || third) {
                    count += 1;
                }
            }
            return count;
    }
}