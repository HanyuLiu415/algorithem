class ListNode {
	int val;// TreeNode node
	ListNode prev;
	ListNode next;
	public ListNode(int val) {
		val = val;
	}
}

public ListNode findPath(TreeNode root, TreeNode node) {
	if (root == null) {
		return null;
	}
	ListNode dummy = new ListNode(0);
	helper(root, dummy, node);
	return dummy.next;

}
public void helper(TreeNode root, ListNode prev, TreeNode target) {
	if (root == null) {
		return;
	}
	ListNode cur = new ListNode(root.val);
	prev.next = cur;
	cur.prev = prev;
	if (root == target) {
		return;
	}
	helper(root.left, cur, target);
	helper(root.right, cur, target);
	prev.next = null;
}