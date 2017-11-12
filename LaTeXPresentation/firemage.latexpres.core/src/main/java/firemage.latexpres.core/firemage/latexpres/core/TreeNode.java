package firemage.latexpres.core;

import java.util.ArrayList;

public class TreeNode {

	private ArrayList<TreeNode> children = new ArrayList<>();
	private TreeNode parent;
	private Displayable value;
	private boolean childrenAllowed = true;

	public TreeNode(Displayable value) {
		this.value = value;
	}

	public boolean addChild(TreeNode child) {
		if (!childrenAllowed)
			return false;

		child.setParent(this);
		if (children == null)
			children = new ArrayList<>();
		children.add(child);

		return true;
	}

	protected void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public ArrayList<TreeNode> getAllChildren() {
		return children;
	}

	public Displayable getValue() {
		return value;
	}

	public TreeNode getParent() {
		return parent;
	}

	public int getChildrenCount() {
		int size = 0;
		for (TreeNode node : children) {
			size += node.getChildrenCount();
		}
		return size + children.size();
	}

	public TreeNode getChild(int index) {
		return children.get(index);
	}

	public boolean childrenAllowed() {
		return childrenAllowed;
	}

	public void setChildrenAllowed(boolean allowed) {
		childrenAllowed = allowed;
		if (!childrenAllowed)
			children.clear();
	}

	public boolean isLeaf() {
		if (children == null || children.size() == 0)
			return true;

		return false;
	}

	public int getDepth() {

		TreeNode nextParent = parent;
		int depth = 0;

		while (nextParent != null) {
			depth++;
			nextParent = nextParent.getParent();
		}

		return depth;
	}

	public ArrayList<TreeNode> getAllChildrenDeep() {
		ArrayList<TreeNode> nodes = new ArrayList<>();
		if (isLeaf())
			return nodes;
		for (TreeNode node : children) {
			if (node == null) {
				continue;
			}
			nodes.addAll(node.getAllChildrenDeep());
		}
		nodes.addAll(children);
		return nodes;
	}
}
