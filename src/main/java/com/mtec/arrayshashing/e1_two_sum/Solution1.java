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
}