package leetcode.n003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> countMap = new HashMap<>();
		int maxLen = 0;
		int j = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
			while (!valid(countMap)) {
				char chj = s.charAt(j);
				countMap.put(chj, countMap.get(chj) - 1);
				j++;
			}
			int len = i - j + 1;
			maxLen = Math.max(maxLen, len);
		}
		return maxLen;

	}

	public int lengthOfLongestSubstring2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			// every time we see an existing character, move j to lastindex+1, so all chars
			// between i and j are unique
			j = Math.max(j, map.getOrDefault(ch, -1) + 1);
			max = Math.max(max, i - j + 1);
			map.put(ch, i);
		}
		return max;
	}

	boolean valid(Map<Character, Integer> countMap) {
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "pwwkew";
		System.out.println(solution.lengthOfLongestSubstring(s));
		System.out.println(solution.lengthOfLongestSubstring2(s));
	}
}
