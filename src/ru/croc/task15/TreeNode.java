package ru.croc.task15;

import java.util.*;

public class TreeNode {
    private final String name;

    private final List<TreeNode> children;

    private final int processingTime;  // это время обработки заявки, считая от корневого отдела

    TreeNode(String name, int processingTime) {
        this.name = name;
        this.processingTime = processingTime;
        this.children = new ArrayList<>();
    }

    public int getTime() {
        return processingTime;
    }

    public void setChild(TreeNode child) {
        this.children.add(child);
    }

    public TreeNode getChildOf(int i) {
        return children.get(i);
    }

    public TreeNode findNode(String target) {
        // итерирование по уровням дерева и нахождение отдела по строке вида "C112"
        TreeNode node = this;
        int index;
        for (int i = 1; i < target.length(); ++i) {
            index = Character.digit(target.charAt(i), 10) - 1;
            node = node.getChildOf(index);
        }
        return node;
    }
}
