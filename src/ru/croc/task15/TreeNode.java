package ru.croc.task15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TreeNode {

    private final TreeNode parent;

    private List<TreeNode> children;

    private final int processingTime;

    TreeNode(int processingTime) {
        this.processingTime = processingTime;
        this.parent = null;
        this.children = new ArrayList<TreeNode>();
    }

    TreeNode(TreeNode parent, int processingTime) {
        this.processingTime = processingTime;
        this.parent = parent;
        this.children = new ArrayList<TreeNode>();
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getChildOf(int i) {
        return children.get(i);
    }

    public int getTime() {
        return processingTime;
    }

    public void setChild(TreeNode child) {
        this.children.add(child);
    }

    public TreeNode findNode(String target) {
        // итерирование по уровням дерева и нахождение node'а по строке вида "C112"
        TreeNode node = this;
        int index;
        for (int i = 1; i < target.length(); ++i) {
            index = Character.digit(target.charAt(i), 10) - 1;
            node = node.getChildOf(index);
        }
        return node;
    }


    public void calculateTotalTime(HashSet<Integer> times) {
        if (this.children.isEmpty()) {
            times.add(this.processingTime);
        }
        for (TreeNode node : this.children) {
            node.calculateTotalTime(times);
        }
    }


}
