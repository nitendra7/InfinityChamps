class Solution {
    static int first(int[] nums,int key){
        int lo=0;
        int hi=nums.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==key){
                ans=mid;
                hi=mid-1;
            }
            else if(nums[mid]>key) hi=mid-1;
            else lo=mid+1;
        }
        return ans;
    }

    static int last(int[] nums,int key){
        int lo=0;
        int hi=nums.length-1;  
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==key){
                ans=mid;
                lo=mid+1;
            }
            else if(nums[mid]<key) lo=mid+1;
            else hi=mid-1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int f=first(nums,target);
        int l=last(nums,target);
        return new int[]{f,l};
    }
}
