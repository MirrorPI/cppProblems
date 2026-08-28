class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31];
        for(String str: strArr) {
            count[str.length()]++;
        }
        int answer = 0;
        for(int i=0; i<31; i++) {
            answer = Math.max(answer, count[i]);
        }
        
        return answer;
    }
}