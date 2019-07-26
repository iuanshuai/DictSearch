package me.syus.dictsearch.service;

public class TreeNode {
    public TreeNode[] children;
    public boolean isLast;

    public TreeNode() {
        this.children = new TreeNode[26];
        this.isLast = false;
    }
}
