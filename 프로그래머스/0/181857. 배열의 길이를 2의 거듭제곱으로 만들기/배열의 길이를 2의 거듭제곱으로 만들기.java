class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        int s = (int)Math.pow(2, i);
        
        int len = arr.length;
        while(len > s) {
            i++;
            s = (int)Math.pow(2, i);
        }
        int[] ans = new int[s];
        for(int j=0; j<len; j++) {
            ans[j] = arr[j];
        }
        
        return ans;
    }
}