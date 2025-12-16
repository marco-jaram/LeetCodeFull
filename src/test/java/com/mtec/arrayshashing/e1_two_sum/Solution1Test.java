package com.mtec.arrayshashing.e1_two_sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class Solution1Test {

    @Test
    void testTwoSum() {
        Solution1 solution = new Solution1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] actual = solution.twoSum(nums, target);
        System.out.println("Input nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Expected: " + Arrays.toString(expected) + ", Actual: " + Arrays.toString(actual));
        Arrays.sort(actual); // Sort for consistent comparison
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTwoSumSecondCase() {
        Solution1 solution = new Solution1();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2}; // Indices of 2 and 4
        int[] actual = solution.twoSum(nums, target);
        System.out.println("Input nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Expected: " + Arrays.toString(expected) + ", Actual: " + Arrays.toString(actual));
        Arrays.sort(actual); // Sort for consistent comparison, as order of indices might vary
        assertArrayEquals(expected, actual);
    }
}
