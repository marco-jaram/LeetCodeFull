package com.mtec.arrayshashing.e1_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // Mapa para almacenar número -> índice
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complemento = target - nums[i];

            // Si el complemento ya está en el mapa, encontramos la solución
            if (numMap.containsKey(complemento)) {
                return new int[] {numMap.get(complemento), i};
            }

            // Guardar el número actual con su índice
            numMap.put(nums[i], i);
        }

        // Nunca se alcanza por los supuestos del problema
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // Ejemplo 1:
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = [2,7,11,15], target = 9");
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        // Ejemplo 2:
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = [3,2,4], target = 6");
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]

        // Ejemplo 3:
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = [3,3], target = 6");
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [0, 1]
    }
}