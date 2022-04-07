package leetcode.n014LongestCommonPrefix;

/**
 * 
 * @author chrislee Question: Write a function to find the longest common prefix
 *         string amongst an array of strings. If there is no common prefix,
 *         return an empty string "". 分析/解題： 題目要求從一組字串陣列中找出其最長的共用前綴，
 *         字串只會由a到z所構成，若沒有的話則回傳空字串。
 */
public class Solution {
	public static String longestCommonPrefix(String[] strings) {
		String pre = "";
		if (strings == null || strings.length == 0) {
			return pre;
		}
		pre = strings[0];
		int i = 1;
		while (i < strings.length) {
			while (strings[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		String[] strings = new String[] { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strings));
	}
}
