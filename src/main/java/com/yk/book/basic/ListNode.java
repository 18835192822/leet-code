package com.yk.book.basic;

/**
 * .
 *
 * @author: yangkun
 * @create: 2021-08-09 20:38
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 根据数组构建链表
     * @param nums
     * @return
     */
    public static ListNode buildList(int[] nums) {
        ListNode first = new ListNode();
        ListNode now = first;

        for (int num : nums) {
            ListNode node = new ListNode(num);
            now.next = node;
            now = node;
        }
        return first.next;
    }

    /**
     * 输出链表
     *
     * @param listNode
     * @return
     */
    public static String listNodeToString(ListNode listNode) {
        StringBuilder sb = new StringBuilder("[");

        while (listNode != null) {
            sb.append(listNode.val).append(",");
            listNode = listNode.next;
        }

        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
