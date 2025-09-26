class Solution {
    static boolean possible(int[][] points,int x){
        if(x<=0) return false;
        int count=1;
        int lp=points[0][1];
        
        for(int i=0;i<points.length;i++){
            if(points[i][0]>lp){
                count++;
                lp=points[i][1];     
            }
        }
        if(count<=x) return true;
        return false;
    }
    public int findMinArrowShots(int[][] points) {
        int lo=1;
        int hi=points.length;
        int ans=0;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(possible(points,mid)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }
}
