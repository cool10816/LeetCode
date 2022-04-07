package leetcode.n004findMedianSortedArrays;

import java.util.Arrays;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double ans = 0d;
		int length1 = nums1.length;
		int length2 = nums2.length;
		int[] nums = new int[length1 + length2];
		System.arraycopy(nums1, 0, nums, 0, length1);
		System.arraycopy(nums2, 0, nums, length1, length2);
		Arrays.sort(nums);

		int result = (length1 + length2) / 2;
		if ((length1 + length2) % 2 != 0) {
			ans = nums[result];
		} else {
			double a = nums[result];
			double b = nums[result - 1];
			ans = (a + b) / 2;
		}
		return ans;
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int median = (length1 + length2 - 1) / 2;
		int[] nums = new int[length1 + length2];
		int i = 0, j = 0, k = 0;
		while (i < length1 && j < length2) {
			if (nums1[i] < nums2[j]) {
				nums[k++] = nums1[i++];
			} else
				nums[k++] = nums2[j++];
		}

		while (i < length1) {
			nums[k++] = nums1[i++];
		}

		while (j < length2) {
			nums[k++] = nums2[j++];
		}

		if (nums.length % 2 == 0)
			return (((double) nums[median] + (double) nums[median + 1]) / 2);
		else
			return (double) (nums[median]);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		// nums1 = [1,2], nums2 = [3,4]
		int[] nums1 = { 1, 2 }, nums2 = { 3 };
		double ans = s.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}
}
