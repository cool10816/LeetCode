package leetcode.n020ValidParentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		if (s.length() % 2 != 0)
			return false;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (stack.size() == 0 || ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}

			char chPop = (char) stack.peek();
			if (ch == ')' && chPop == '(') {
				stack.pop();
			} else if (ch == ']' && chPop == '[') {
				stack.pop();
			} else if (ch == '}' && chPop == '{') {
				stack.pop();
			} else {
				stack.push(ch);
			}

		}

		return stack.size() == 0;
	}
}
