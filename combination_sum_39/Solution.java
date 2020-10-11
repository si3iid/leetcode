package combination_sum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>39. Combination Sum </b> <div>
 * <p>
 * Given a <strong>set</strong> of candidate numbers (<code>candidates</code>)
 * <strong>(without duplicates)</strong> and a target number
 * (<code>target</code>), find all unique combinations in
 * <code>candidates</code>&nbsp;where the candidate numbers sums to
 * <code>target</code>.
 * </p>
 * 
 * <p>
 * The <strong>same</strong> repeated number may be chosen from
 * <code>candidates</code>&nbsp;unlimited number of times.
 * </p>
 * 
 * <p>
 * <strong>Note:</strong>
 * </p>
 * 
 * <ul>
 * <li>All numbers (including <code>target</code>) will be positive
 * integers.</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ul>
 * 
 * <p>
 * <strong>Example 1:</strong>
 * </p>
 * 
 * <pre>
 * <strong>Input:</strong> candidates = <code>[2,3,6,7], </code>target = <code>7</code>,
<strong>A solution set is:</strong>
[
  [7],
  [2,2,3]
]
 * </pre>
 * 
 * <p>
 * <strong>Example 2:</strong>
 * </p>
 * 
 * <pre>
 * <strong>Input:</strong> candidates = [2,3,5]<code>, </code>target = 8,
<strong>A solution set is:</strong>
[
&nbsp; [2,2,2,2],
&nbsp; [2,3,3],
&nbsp; [3,5]
]
 * </pre>
 * 
 * <p>
 * &nbsp;
 * </p>
 * <p>
 * <strong>Constraints:</strong>
 * </p>
 * 
 * <ul>
 * <li><code>1 &lt;= candidates.length &lt;= 30</code></li>
 * <li><code>1 &lt;= candidates[i] &lt;= 200</code></li>
 * <li>Each element of <code>candidate</code> is unique.</li>
 * <li><code>1 &lt;= target &lt;= 500</code></li>
 * </ul>
 * </div>
 */
class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(candidates, result, new ArrayList<>(), target, 0);
		return result;
	}

	public void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int remaining, int index) {
		if (remaining < 0)
			return;
		else if (remaining == 0)
			result.add(new ArrayList<>(temp));
		else {
			// use backtracking technique to simulating taking a number and not taking a
			// number
			for (int i = index; i < nums.length; i++) {
				temp.add(nums[i]);
				dfs(nums, result, temp, remaining - nums[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}