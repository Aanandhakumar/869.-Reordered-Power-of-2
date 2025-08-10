//869. Reordered Power of 2 in java ...


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