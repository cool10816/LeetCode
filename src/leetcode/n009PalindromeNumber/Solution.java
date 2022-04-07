package leetcode.n009PalindromeNumber;

public class Solution {
	public boolean isPalindrome(int x) {
		boolean result = false;
		int tmp = x;
		int after = 0;
		if (x < 0) {
			return result;
		}

		while (tmp != 0) {
			after = after * 10 + tmp % 10;
			tmp = tmp / 10;
		}

		if (x == after) {
			result = true;
		}

		return result;
	}

	public boolean isPalindrome2(int x) {
		boolean result = false;
		if (x < 0) {
			return result;
		}

		String tmp = Integer.toString(x);
		int length = tmp.length();
		int mid = tmp.length() / 2;
		int midUp , midDown = 0;
		if (length % 2 != 0) {
			midUp = mid + 1;
			midDown = mid -1;
		} else {
			midUp = mid;
			midDown = mid -1;
		}
		
		while(midDown >= 0) {
			if (tmp.charAt(midUp) != tmp.charAt(midDown)) {
				return result;
			}
			midUp ++;
			midDown --;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome2(1));

	}
}
