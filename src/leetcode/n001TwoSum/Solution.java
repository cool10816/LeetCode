package leetcode.n001TwoSum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author chrislee 
 * Question: Given an array of integers, return indices of the
 *         two numbers such that they add up to a specific target. You may
 *         assume that each input would have exactly one solution, and you may
 *         not use the same element twice.
 */
public class Solution {
	/**
	 * 分析/解題： 題目要求是，在一組陣列中找出兩個數，其加總恰等於給定值。 每個數不能被重複使用，且必剛好只有一個解。
	 * 像這種題目，由於被擺在第一題，大多數狀況都不會被拿來考XD 但，凡事總有例外。
	 */
	public static List<int[]> towSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<int[]> intList = new ArrayList<int[]>();
		if (nums != null && nums.length > 0) {
			System.out.println("nums length is:" + nums.length);
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement)) {
					intList.add(new int[] { map.get(complement), i });
				}
				map.put(nums[i], i);
			}
			return intList;
		}
		throw new IllegalArgumentException("No Answer");
	}
	
	public static int[] towSum2(int[] nums, int target) {
		if (nums.length == 2) {
			return new int[] { 0, 1 };
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { 0, 1 };
	}

	public static void main(String[] args) {
		long time1, time2;
		String message = "第%d個數字為%d加上第%d個數字為%d等於%d";
		String timeMessage = "花了%d秒";
		Calendar cal = Calendar.getInstance();
		String timeInMills = String.valueOf(cal.getTimeInMillis());
		int randomParam = Integer.valueOf(timeInMills.substring(timeInMills.length() - 2, timeInMills.length()));
		// System.out.println(randomParam);
		int[] nums = new int[randomParam];
		for (int i = 0; i < randomParam; i++) {
			int random = (int) (Math.random() * 99) + 1;
			// System.out.println(random);
			nums[i] = random;
		}
		int target = 53;
		time1 = System.currentTimeMillis();
		List<int[]> result = towSum(nums, target);
		time2 = System.currentTimeMillis();
//		System.out.println(time2 - time1);
		System.out.println(String.format(timeMessage, (time2 - time1)));
		if (result != null) {
			for (int[] is : result) {
				System.out.println(String.format(message, is[0], nums[is[0]], is[1], nums[is[1]], target));
			}
		}
	}
}
