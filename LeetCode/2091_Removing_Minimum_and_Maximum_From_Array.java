class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int maxval=Integer.MIN_VALUE;
        int minval=Integer.MAX_VALUE;
        int minInd=-1;
        int maxInd=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<minval)
            {
                minval=nums[i];
                minInd=i;
            }
            if(nums[i]>maxval)
            {
                maxval=nums[i];
                maxInd=i;
            }
        }
        int a=Math.min(minInd,maxInd);
        int b =Math.max(minInd,maxInd);
         int front=b+1;
         int back=n-a;
         int both=(a+1)+(n-b);
         return Math.min(front,Math.min(back,both));

    }
}
