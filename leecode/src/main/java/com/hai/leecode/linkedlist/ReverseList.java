package com.hai.leecode.linkedlist;

/**
 * leetcode 206
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-15 11:00
 */
public class ReverseList {


    //迭代法反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;


    }

    //递归法反转链表
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;

    }




}
