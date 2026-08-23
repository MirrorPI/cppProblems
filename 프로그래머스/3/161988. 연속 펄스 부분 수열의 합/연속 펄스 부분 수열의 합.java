class Solution {
    
    final int[] purse = {1, -1};
    final int[] purse2 = {-1, 1};
    
    public long solution(int[] sequence) {
        int size = sequence.length;
        long[] oneStartDp = new long[size];
        long[] minusOneStartDp = new long[size];
        
        oneStartDp[0] = sequence[0];
        minusOneStartDp[0] = sequence[0] * -1;
        long answer = Math.max(oneStartDp[0], minusOneStartDp[0]);
        for(int i=1; i<size; i++) {
            int purseValue = purse[i%2] * sequence[i];
            oneStartDp[i] = Math.max(purseValue, oneStartDp[i-1] + purseValue);
            answer = Math.max(oneStartDp[i], answer);
        }
        
        
        for(int i=1; i<size; i++) {
            int purseValue = purse2[i%2] * sequence[i];
            minusOneStartDp[i] = Math.max(purseValue, minusOneStartDp[i-1] + purseValue);
            answer = Math.max(minusOneStartDp[i], answer);
        }
        
        return answer;
    }
}