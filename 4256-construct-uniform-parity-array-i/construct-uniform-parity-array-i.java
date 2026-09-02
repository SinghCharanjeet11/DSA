class Solution {
    public boolean uniformArray(int[] nums1) {
        int bitmask = 0;
        for (int i : nums1) {
            bitmask ^= i;
        }
        int n = nums1.length;
        int[] nums2 = new int[n];
        if (bitmask % 2 != 0) {
            int even = -1;
            for (int i = 0; i < n; i++) {
                if (nums1[i] % 2 == 0) {
                    even = nums1[i];
                    break;
                }
            }
            if (even != -1) {
                for (int i = 0; i < n; i++) {
                    if (nums1[i] % 2 != 0) {
                        nums2[i] = nums1[i];
                    } 
                    else {
                        nums2[i] = nums1[i] - 1;
                    }
                }
            }
        } 
        else {
            for (int i = 0; i < n; i++) {
                if (nums1[i] % 2 == 0) {
                    nums2[i] = nums1[i];
                } 
                else {
                    boolean found = false;
                    for (int j = 0; j < n; j++) {
                        if (i != j && nums1[j] % 2 != 0) {
                            nums2[i] = nums1[i] - nums1[j];
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}