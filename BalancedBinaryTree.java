/*************************************************************
 *
 * Amazon: (LeetCode No.110 Balanced Binary Tree)
 * Given a binary tree, determin if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 *
 * Keyword: BalancedBinaryTree
 *
 * @author Jiafeng Ni
 *
 *************************************************************/

import java.util.*;

public class BalancedBinaryTree{
    
    /**
     * This implementation is wasted time and stack space
     */
    public boolean isBalanced1 (TreeNode root) {
	if (root == null)      {return true;}
	else if (Math.abs(height(root.left) - height(root.right)) > 1) { return false; }
	else                   { return isBalanced(root.left) && isBalanced(root.right);}
    }

    private static int height(TreeNode node) {
	if (node == null) { return -1; }
	else              { return 1 + Math.max(height(node.left), height(node.right));}
    }

    /**
     * Mark depth as -1 if subtree already not balanced 
     */
    public static boolean isBalanced2(TreeNode root) {
	return isBalancedHelper(root) != -1;
    }

    private static int isBalancedHelper(TreeNode root) {
	if (root == null) { return 0; }
	
	int leftDepth = isBalancedHelper(root.left);
	if (leftDepth == -1) { return -1; }
	
	int rightDepth = isBalancedHelper(root.right);
	if (rightDepth == -1) {return -1;}
	
	return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
    
}