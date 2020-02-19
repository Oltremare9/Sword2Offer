package 面试题21.调整数组顺序使奇数位于偶数前面;

class Solution {
    public int[] exchange(int[] nums) {
        /*双循环嵌套
        int index=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i>=index)
                break;
            if(!isOdd(nums[i])){
                for(int j=index;j>=i;j--){
                    if (isOdd(nums[j])){
                        swap(nums,i,j);
                        index=j;
                        break;
                    }
                }
            }
        }
        */
        //快排
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while(left<right && isOdd(nums[left]))
                left++;
            while(left<right && !isOdd(nums[right]))
                right--;
            swap(nums,left,right);
        }
        return nums;
    }
    private static boolean isOdd(int num){
        if(num%2==1)
            return true;
        else
            return false;
    }
    private static int[] swap(int[]nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        return nums;
    }
}