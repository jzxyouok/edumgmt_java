package net.shinc.common;

import java.util.List;

public class TreeNode<T> {
	private Integer id;
	
	private T item;
	
	private Integer parent;
	
	private List<TreeNode> child;
	
	private boolean isLeaf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChild() {
		return child;
	}

	public void setChild(List<TreeNode> child) {
		this.child = child;
	}

	public boolean isLeaf() {
		if( child == null || child.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
