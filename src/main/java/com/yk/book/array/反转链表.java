package com.yk.book.array;

import com.yk.book.basic.ListNode;

/**
 * 反转链表.
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 题解：
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
 *
 * @author: yangkun
 * @create: 2021-08-09 20:41
 */
public class 反转链表 {


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode l1 = ListNode.buildList(arr1);

        ListNode l2 = reverseList(l1);

        System.out.println(ListNode.listNodeToString(l2));
    }

    /**
     *
     * 使用3个指针来实现反转
     *
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     * 递归方式解决
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //返回反转后的头节点
        ListNode listNode = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
