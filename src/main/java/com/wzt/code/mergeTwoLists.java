package com.wzt.code;

/**
 * Created by wzt on 2017/5/9.
 */
public class mergeTwoLists {

     // Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode merge;
        if(l1.val<l2.val){
            merge=l1;
            merge.next=mergeTwoLists(l1.next,l2);
        }
        else {
            merge=l2;
            merge.next=mergeTwoLists(l1,l2.next);
        }
        return merge;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        System.out.printf("%d\n", mergeTwoLists(l1, l2).val);
        System.out.println(mergeTwoListsBest(l1, l2).val);
    }
}
