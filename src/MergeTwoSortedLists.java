/**
 * Created by Administrator on 2015/4/5.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode pNode1 = l1;
        ListNode pNode2 = l2;

        if (pNode1.val <= pNode2.val) {
            result = new ListNode(pNode1.val);
            pNode1 = pNode1.next;
        } else {
            result = new ListNode(pNode2.val);
            pNode2 = pNode2.next;
        }

        ListNode tailNode = result;

        while (pNode1 != null && pNode2 != null) {
            if (pNode1.val <= pNode2.val) {
                ListNode node = new ListNode(pNode1.val);
                tailNode.next = node;
                pNode1 = pNode1.next;
            } else {
                ListNode node = new ListNode(pNode2.val);
                tailNode.next = node;
                pNode2 = pNode2.next;
            }
            tailNode = tailNode.next;
        }

        ListNode tmpNode = pNode1 == null ? pNode2 : pNode1;
        while(tmpNode != null) {
            ListNode node = new ListNode(tmpNode.val);
            tailNode.next = node;
            tailNode = tailNode.next;
            tmpNode = tmpNode.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1, 3, 5, 9});
        ListNode l2 = ListNode.build(new int[]{0});
        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        ListNode newNode = sol.mergeTwoLists(l1, l2);
        ListNode.print(newNode);
    }
}
