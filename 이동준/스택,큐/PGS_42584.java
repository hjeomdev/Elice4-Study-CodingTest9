class Solution {
    public int[] solution(int[] prices) {
        /*
        처음 문제 이해하는데 좀 오래걸렸는데 해당 시점에 해당 가격으로 주식을 샀다고 하고
        몇 초간 가격이 떨어지지 않은지 측정한다고 생각하면 편함
        */
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int tmp=0;
            for(int j=i;j<prices.length-1;j++){
                tmp++;
                if(prices[i]>prices[j+1])
                    break;
            }
            answer[i]=tmp;
        }
        return answer;
    }
}