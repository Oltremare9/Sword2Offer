package 面试题51.数组中的逆序对;

class Solution {
    int res = 0;

    public int reversePairs(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        mergeSort(nums, start, end);
        return res;
    }

    private void mergeSort(int nums[], int start, int end) {
        if (start == end || end < 0)
            return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int temp[] = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right])
                temp[index++] = nums[left++];
            else {
                res += mid - left + 1;
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid)
            temp[index++] = nums[left++];
        while (right <= end)
            temp[index++] = nums[right++];
        left = start;
        index = 0;
        while (index < temp.length) {
            nums[left++] = temp[index++];
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int a[] = {7, 5, 6, 4};
        System.out.println(solution.reversePairs(a));
    }
}