package 面试题53_I.在排序数组中查找数字I;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        int left = getMinIndex(nums, start, end, target);
        int right = getMaxIndex(nums, start, end, target);
        if (left == -1)
            return 0;
        return right - left + 1;
    }

    private int getMinIndex(int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target)
                    return mid;
                else end = mid - 1;
            }
        }
        return -1;
    }

    private int getMaxIndex(int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                else start = mid + 1;
            }
        }
        return -1;
    }
}