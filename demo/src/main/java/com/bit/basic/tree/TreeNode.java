package com.bit.basic.tree;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName TreeNode.java
 * @Description TODO
 * @createTime 2019年11月23日 17:26:00
 */
public class TreeNode<U extends Comparable, V extends IIdentity<U, V>> implements Serializable {

    private U id;

    private V value;

    private TreeNode<U, V> parent;

    protected List<TreeNode<U, V>> childList;

    private Map<U, TreeNode<U, V>> treeNodeMap = new HashMap<>();

    public TreeNode() {}

    public TreeNode(V value) {
        if(value != null) {
            this.value = value;
            this.id = value.getId();
        }
    }

    public TreeNode(U id, V value) {
        this.id = id;
        this.value = value;
    }

    //先找到根节点，然后逐级向下构造，可以使用traverse函数
    public void generateTree(List<TreeNode<U, V>> treeNodeList) {

    }

    /** 获取树的根节点，如果根节点为null，抛出异常
     * @return root节点对象
     */
    private TreeNode getRoot() {
        TreeNode<U, V> treeNode = this;
        while(!this.getValue().isRoot(treeNode.getId())) {
            if(treeNode == null) {
                break;
            }
            treeNode = treeNode.getParent();
        }
        if(treeNode == null) {
            throw new RuntimeException("根节点不能为null");
        }
        return treeNode;
    }

    public void addChildList(List<TreeNode<U, V>> treeNodes) {
        addChildNodeList(this, treeNodes);
    }

    public void addChildNodeList(TreeNode<U, V> parentNode, List<TreeNode<U, V>> treeNodes) {
        treeNodes.forEach((node) -> {
            if(!parentNode.getId().equals(node.getParentId(node))) {
                throw new RuntimeException("parentId=" + String.valueOf(parentNode.getId())
                        + ";nodeId=" + String.valueOf(node.getId()));
            };
        });
        for (int i = treeNodes.size() - 1; i >= 0; --i) {
            parentNode.addChildNode(treeNodes.get(i));
            treeNodes.get(i).parent = parentNode;
        }
    }

    public void addChildNode(TreeNode<U, V> treeNode) {
        if (childList == null) {
            childList = new ArrayList<TreeNode<U, V>>();
        }
        childList.add(treeNode);
    }

    public void add(U id, TreeNode treeNode) {
        treeNodeMap.put(id, treeNode);
    }

    public void delete() {
        TreeNode parentNode = this.getParent();
        if (parentNode != null) {
            parentNode.deleteChildNode(this.getId());
        }
    }

    public void deleteChildNode(U childId) {
        List<TreeNode<U, V>> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }

    public V findValueById(U id) {
        TreeNode<U, V> treeNode = findTreeNodeById(id);
        if (treeNode == null) {
            return null;
        }
        return treeNode.getValue();
    }

    public TreeNode<U, V> findTreeNodeById(U id) {
        if (id == null) {
            throw new RuntimeException("id不能为空");
        }
        return treeNodeMap.get(id);
    }

    public List<V> getPromotionList() {
        List<V> list = new ArrayList<>();
        treeNodeMap.values().forEach(n -> list.add(n.getValue()));
        return list;
    }

    public U getId() {
        return id;
    }

    public void setId(U id) {
        this.id = id;
    }

    public List<TreeNode<U, V>> getChildList() {
        return childList;
    }

    public TreeNode<U, V> getParent() {
        return parent;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setChildList(List<TreeNode<U, V>> childList) {
        this.childList = childList;
    }

    private U getParentId(TreeNode<U, V> treeNode) {
        return treeNode.getParent().getId();
    }


    public void traverse(IVisit<V> visit) {
        if (childList == null || childList.isEmpty()) {
            return;
        }
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode<U, V> child = childList.get(i);
            visit.visit(child.getValue());
            child.traverse(visit);
        }
    }

    public List<TreeNode<U, V>> findLeaves() {
        List<TreeNode<U, V>> treeNodes =
                treeNodeMap
                        .values()
                        .stream()
                        .filter(u -> u.isLeaf() && value.isRoot(u.getId()))
                        .collect(Collectors.toList());
        return treeNodes;
    }

    public boolean isLeaf() {
        if (childList == null || childList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(V value) {
        if (value == null || value.getId() == null || getClass() != value.getClass()) {
            return false;
        }
        if (id.equals(value.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
