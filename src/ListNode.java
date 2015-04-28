/**
 * Created by Administrator on 2015/4/6.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode build(int num[]) {
        if (num.length == 0)
            return null;

        ListNode headNode = new ListNode(num[0]);
        ListNode preNode = headNode;

        for (int i = 1; i < num.length; i++) {
            ListNode curNode = new ListNode(num[i]);
            preNode.next = curNode;
            preNode = curNode;
        }

        return headNode;
    }

    public static void print(ListNode head) {
        ListNode pNode = head;
        while (pNode != null) {
            System.out.print(pNode.val);
            System.out.println(" ");
            pNode = pNode.next;
        }
        System.out.println();
    }
}
