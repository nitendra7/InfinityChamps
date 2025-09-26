class Solution{
    public int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] res=new int[n-k+1];
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        res[0]=pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.add(new int[]{nums[i],i});
            while(pq.peek()[1]<=i-k){
                pq.poll();
            }
            res[i-k+1]=pq.peek()[0];
        }
        return res;
    }
}