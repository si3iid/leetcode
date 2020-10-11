package find_the_duplicate_number_287;

/**
 * <b>287. Find the Duplicate Number</b>
 * <p>
 * Given an array <i>nums</i> containing <i>n</i> + 1 integers where each
 * integer is between 1 and <i>n</i> (inclusive), prove that at least one
 * duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 * </p>
 * 
 * <p>
 * <b>Example 1:</b>
 * </p>
 * 
 * <pre>
 * <b>Input:</b> <code>[1,3,4,2,2]</code>
<b>Output:</b> 2
 * </pre>
 * 
 * <p>
 * <b>Example 2:</b>
 * </p>
 * 
 * <pre>
 * <b>Input:</b> [3,1,3,4,2]
<b>Output:</b> 3
 * </pre>
 * 
 * <p>
 * <b>Note:</b>
 * </p>
 * 
 * <ol>
 * <li>You <b>must not</b> modify the array (assume the array is read
 * only).</li>
 * <li>You must use only constant, <i>O</i>(1) extra space.</li>
 * <li>Your runtime complexity should be less than
 * <em>O</em>(<em>n</em><sup>2</sup>).</li>
 * <li>There is only one duplicate number in the array, but it could be repeated
 * more than once.</li>
 * </ol>
 */
class Solution {
	/**
	 * Optimal solution is the Floyd's Tortoise and Hare (Cycle Detection)
	 * 
	 */
	public int findDuplicate(int[] nums) {
		// fast is moving twice the speed of the slow
		int slow = nums[0];
		int fast = nums[nums[0]];

		// keep moving until the cycle a cycle is found
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		// reset slow pointer
		slow = 0;

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}
}