class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];

        for (int i = 0; i < len1; i++) {
            int j = 0;
            int nextGreater = -1;

            while (j < len2 && nums1[i] != nums2[j]) j++;

            if (j == len2) { // not found (extra safety)
                result[i] = -1;
                continue;
            }

            j++; // start searching right side

            while (j < len2) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
                j++;
            }

            result[i] = nextGreater;
        }

        return result;
    }
}




// import java.util.*;

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
//         Map<Integer, Integer> next = new HashMap<>();
//         Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack

//         //Create a map with next > element for each element in num2 .. if end of stack then enter -1;

//         for (int x : nums2) {
//             while (!stack.isEmpty() && x > stack.peek()) {
//                 next.put(stack.pop(), x);
//             }
//             stack.push(x);
//         }

//         // remaining have no next greater
//         while (!stack.isEmpty()) {
//             next.put(stack.pop(), -1);
//         }

//         int[] res = new int[nums1.length];
//         for (int i = 0; i < nums1.length; i++) {
//             res[i] = next.get(nums1[i]);
//         }
//         return res;
//     }
// }
