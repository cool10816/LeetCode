package leetcode.n002addTwoNumbers;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = s.new ListNode(2);
		ListNode l11 = s.new ListNode(4);
		l1.next = l11;
		ListNode l12 = s.new ListNode(3);
		l11.next = l12;
		
		ListNode l2 = s.new ListNode(5);
		ListNode l21 = s.new ListNode(6);
		l1.next = l21;
		ListNode l22 = s.new ListNode(4);
		l21.next = l22;
		
		ListNode ans = s.new ListNode(0);
		ans = addTwoNumbers(l1, l2);
		System.out.println(ans);
		
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new Solution().new ListNode(0);
		ListNode tmp = ans;
		while (l1 != null || l2 != null) {
			int a = 0, b = 0, sum = 0, carry = 0;

			if (l1 == null) {
				a = 0;
			} else {
				a = l1.val;
				l1 = l1.next;
			}

			if (l2 == null) {
				b = 0;
			} else {
				b = l2.val;
				l2 = l2.next;
			}

			sum = tmp.val + a + b;
			if (sum >= 10) {
				sum = sum % 10;
				carry++;
			}

			tmp.val = sum;

			if (l1 != null || l2 != null || carry >= 1) {
				tmp.next = new Solution().new ListNode(carry);
				tmp = tmp.next;
			}

		}
		return ans;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
