package com.algorithm;

import com.algorithm.treenode.TreeNode;

public class BinaryTreeMaximumPathSum {
	int sum = 0x80000000; // 赋值为最小值
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		getSum(root);
		return sum;
	}

	public int getSum(TreeNode root) {
		if (root == null) {
			// 没有节点，返回0
			return 0;
		}
		// 后序遍历
		int leftNum = getSum(root.left);
		int rightNum = getSum(root.right);
		// 判断子节点的值是否小于0
		if (leftNum < 0) {
			leftNum = 0;
		}
		if (rightNum < 0) {
			rightNum = 0;
		}
		// 计算当前路径值，和现有sum比较
		int temp = leftNum + rightNum + root.val;
		if (temp > sum) {
			sum = temp;
		}
		// 返回左右子节点中值比较大的一个
		return (leftNum > rightNum ? leftNum : rightNum) + root.val;
	}
}
