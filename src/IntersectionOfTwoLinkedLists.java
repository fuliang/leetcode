/**
 * Created by fuliang on 2015/4/8.
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:  a1 → a2
 *               ↘
 *                  c1 → c2 → c3
 *                ↗
 * B: b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 *  Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory
 */

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode pShort, pLong;

        if (lenA > lenB) {
            pShort = headB;
            pLong = headA;
        } else {
            pShort = headA;
            pLong = headB;
        }

        int diff = Math.abs(lenA - lenB);
        for (int i = 0; i < diff; i++) {
            pLong = pLong.next;
        }

        while (pShort != null && pLong != null) {
            if (pShort == pLong) {
                break;
            }
            pShort = pShort.next;
            pLong = pLong.next;
        }
        return pShort;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            ++len;
        }
        return len;
    }
}
