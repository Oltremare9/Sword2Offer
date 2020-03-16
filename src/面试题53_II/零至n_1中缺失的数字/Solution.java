package 面试题53_II.零至n_1中缺失的数字;

class Solution {
    //    public int missingNumber(int[] nums) {
//        int i=0;
//        for(i=0;i<nums.length;i++){
//            if(nums[i]!=i)
//                return i;
//        }
//        return i;
//    }
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] != mid) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return start;
    }
}