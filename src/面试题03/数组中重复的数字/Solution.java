package 面试题03.数组中重复的数字;

class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean isDuplicated[]=new boolean[nums.length];
        int first=0;
        while(nums[first]==first)
            first++;
        int temp=first;
        isDuplicated[temp]=true;
        while(true){
            if(isDuplicated[nums[temp]]==false) {
                isDuplicated[nums[temp]] = true;
                temp=nums[temp];
            }else{
                return nums[nums[temp]];
            }
        }
    }
}