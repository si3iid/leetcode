package add_two_numbers_2;

/**
 * <b>2. Add Two Numbers </b>
 * <p>
 * You are given two <b>non-empty</b> linked lists representing two non-negative
 * integers. The digits are stored in <b>reverse order</b> and each of their
 * nodes contain a single digit. Add the two numbers and return it as a linked
 * list.
 * </p>
 * 
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * </p>
 * 
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <pre>
 * <b>Input:</b> (2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
<b>Output:</b> 7 -&gt; 0 -&gt; 8
<b>Explanation:</b> 342 + 465 = 807.
 * </pre>
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode finalResult = new ListNode(-1);
		ListNode result = finalResult;
		ListNode curr1 = l1;
		ListNode curr2 = l2;

		int sum = 0;
		int carry = 0;
		int lastDigit = 0;

		while (curr1 != null || curr2 != null) {

			// prefill with zero until other list has also been traversed
			if (curr1 == null) {
				curr1 = new ListNode(0);
			}

			// prefill with zero until other list has also been traversed
			if (curr2 == null) {
				curr2 = new ListNode(0);
			}

			// calculate the sum based on both lists and previous carry
			sum = curr1.val + curr2.val + carry;
			lastDigit = sum % 10;
			carry = sum / 10;

			// create a new list node for the last digit alone
			result.next = new ListNode(lastDigit);
			result = result.next;

			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		if (carry != 0) {
			result.next = new ListNode(carry);
		}

		return finalResult.next;
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
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