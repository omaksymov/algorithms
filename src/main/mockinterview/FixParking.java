package mockinterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Assuming we have a list of license plate numbers (of cars) represented by integers,
 * let's consider that we have a parking, where all slots except one are expected to be occupied by specific car.
 * Also let's assume that something went wrong and all cars were re-shuffled in the parking.
 * The task is to provide an algorithm to fix this and put all cars into correct places.
 */
public class FixParking {
    /*
    Idea is to walk through every expected car position, find it in array of actual positions, then move car into it's
    expected position. If expected position is occupied - move occupying car into empty spot.
    In general algorithm will be O(n) runtime (see explanation for lookup below). Space complexity: O(n) (additional
    space for lookup hashmap)

    Illustration of solution:
    Let's assume
     expected: 1, 3, n, 5, 8 // n means empty slot
     actual:   8, 3, 5, n, 1
     step-by-step moves:
               1, 3, 5, 8, n
               1, 3, n, 5, 8
     Such algorithm may take O(n^2) in case for every expected car position we'll search in array of their
     actual positions. Thus, we need to perform additional O(n) step to map cars to their actual positions.
     After that every lookup will be O(1).
        Example:
        a: {1 -> 4, 3 -> 1, n -> 3, 5 -> 2, 8 -> 0}

     */
    static class Solution1 {

        public void fixParking(Integer[] expected, Integer[] actual) {
            Map<Integer, Integer> aMap = mapCarToPosition(actual);
            int n = expected.length;
            int actualPos;
            for (int i = 0; i < n; i++) {
                if (expected[i] == null) continue;
                actualPos = aMap.get(expected[i]);
                move(actualPos, i, actual, aMap);
            }
        }

        private Map<Integer, Integer> mapCarToPosition(Integer[] a) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = a.length;
            for (Integer i = 0; i < n; i++) {
                map.put(a[i], i);
            }
            return map;
        }

        private void move(int actualPos, int expectedPos,
                          Integer[] a, Map<Integer, Integer> aMap) {
            if (actualPos == expectedPos) return;
            // remember the car, which is currently at expected position
            Integer expectedPosCar = a[expectedPos];
            // In case expected position is non-empty - move existing car into empty spot first
            if (expectedPosCar != null) {
                int emptyPos = aMap.get(null);
                a[emptyPos] = expectedPosCar;
                aMap.put(expectedPosCar, emptyPos);
            }
            a[expectedPos] = a[actualPos];
            a[actualPos] = null;
            aMap.put(a[expectedPos], expectedPos);
            aMap.put(null, actualPos);
        }
    }

    /*
        Idea is similar to solution 1, but more close real-life: if during move of car into its expected place
        different car occupies its place - then instead of moving occupying car into empty spot we can lookup it's
        expected position and move it using the same approach until all the cars are on their correct place.

        Given example from Solution 1:
            expected: 1, 3, n, 5, 8 // n means empty slot
            actual:   8, 3, 5, n, 1
            step-by-step moves:
                      1, 3, 5, n, n // 8 moved out from position 0 and waiting to be placed into position 4
                      1, 3, 5, n, 8 // position 4 had been just freed by car 1, so just take its place.
                                    // Procedure is not finished as we still have cars in wrong places.
                      1, 3, n, n, 8 // position 3 should be empty, so move 5 out of that place
                      1, 3, n, 5, 8 // car 5 placed into its expected position 3, which was free.
         Runtime: O(n)
         Space: O(2n) = O(n) // need licensePlate -> position mapping for both expected and actual positions
     */
    static class Solution2 {
        public void fixParking(Integer[] expected, Integer[] actual) {
            int n = expected.length;
            Map<Integer, Integer> aMap = mapCarToPosition(actual);
            Map<Integer, Integer> eMap = mapCarToPosition(expected);
            int scanIndex = 0; // iterates over expected parking positions
            Integer occupyingCar;
            int processPos;
            while (scanIndex < n) {
                processPos = scanIndex; // process below may stop while not all cars are put into correct places,
                                        // so we make separate indexation for process
                while (!Objects.equals(expected[processPos], actual[processPos])) {
                    occupyingCar = move(processPos, aMap, actual, expected);
                    processPos = eMap.get(occupyingCar);
                }
                scanIndex++;
            }
        }

        private Map<Integer, Integer> mapCarToPosition(Integer[] a) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = a.length;
            for (Integer i = 0; i < n; i++) {
                map.put(a[i], i);
            }
            return map;
        }

        // Return car which was occupying that place or null if place was empty
        private Integer move(int expectedPos, Map<Integer, Integer> aMap, Integer[] actual, Integer[] expected) {
            Integer expectedCar = expected[expectedPos]; // may be null (empty)
            int actualPos = aMap.get(expectedCar);
            Integer occupyingCar = actual[expectedPos];
            actual[expectedPos] = expectedCar;
            if (actualPos != -1) {
                actual[actualPos] = null;
            }
            aMap.put(expectedCar, expectedPos);
            aMap.put(null, actualPos);
            aMap.put(occupyingCar, -1);
            return occupyingCar;
        }
    }
}
