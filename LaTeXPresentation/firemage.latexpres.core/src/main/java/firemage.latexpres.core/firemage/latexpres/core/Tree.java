package firemage.latexpres.core;

import java.util.ArrayList;

public class Tree {

	private TreeNode root;

	public Tree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public int getSize() {
		return root.getChildrenCount() + 1;
	}

	public ArrayList<TreeNode> getAllNodes() {
		ArrayList<TreeNode> allNodes = root.getAllChildrenDeep();
		allNodes.add(root);
		return allNodes;
	}
}
