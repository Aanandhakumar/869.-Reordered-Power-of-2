//869. Reordered Power of 2 in java ...

// By checking Array is equal after sorting
// https://leetcode.com/problems/reordered-power-of-2/
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] target = String.valueOf(n).toCharArray();
        Arrays.sort(target);

        for(int i = 0; i<31; i++){
            int num = 1<<i;
            char[] powerOfTwo = String.valueOf(num).toCharArray();
            Arrays.sort(powerOfTwo);

            if(Arrays.equals(target,powerOfTwo)){
                return true;
            }
        }
        return false;
    }
}

// Time Complexity: O(31 * log n) ~ O(log n)
// Space Complexity: O(log n) for storing the characters of the number


// Alternative Solution: Using HashMap to count digits

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] targetCount = Digitcount(n);

        for(int i = 0; i<31; i++){
            
            int[] powerOfTwoCount = Digitcount(1<<i);

            if(matches(targetCount,powerOfTwoCount)){
                return true;
            }
        }
        return false;
    }
    private int[] Digitcount(int n){
        int[] count = new int[10];
        while(n>0){
            count[n%10]++;
            n /= 10;
        }
        return count;
    }

    private boolean matches(int[] a, int[] b){
        for(int i = 0; i<10; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}

// Time Complexity: O(31 * d) ~ O(d) where d is the number of digits in n
// Space Complexity: O(d) for storing the digit counts
