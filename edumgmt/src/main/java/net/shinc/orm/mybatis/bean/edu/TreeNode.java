package net.shinc.orm.mybatis.bean.edu;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private T item; // 节点数据
	
	private Integer id;
	
	private Integer parent;
	// 子本身也是一个节点数据
	private List<TreeNode<T>> child;
	
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

	public List<TreeNode<T>> getChild() {
		return child;
	}

	public void setChild(List<TreeNode<T>> child) {
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
	
	public void addChild(TreeNode<T> child) {
		if(this.child == null) {
			 this.child = new ArrayList<TreeNode<T>>();
		}
		this.child.add(child);
	}
	
}
