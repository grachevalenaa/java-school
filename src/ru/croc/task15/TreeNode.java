package ru.croc.task15;

import java.util.*;

public class TreeNode {
    private final List<TreeNode> children;

    private final int processingTime;  // это время обработки заявки, считая от корневого отдела

    TreeNode(int processingTime) {
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

    public int calculateTotalTime(HashSet<Integer> times) {
        /*поле processingTime листьев дерева уже содержат в себе различные времена обработки (финальные);
        доходим до всех листьев дерева и добавляем их в times, возвращаем максимальное время*/
        if (this.children.isEmpty()) {
            times.add(this.processingTime);
        }
        for (TreeNode node : this.children) {
            node.calculateTotalTime(times);
        }
        return Collections.max(times);
    }
}
