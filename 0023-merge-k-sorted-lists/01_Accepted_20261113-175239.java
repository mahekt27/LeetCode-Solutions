import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                (first, second) -> Integer.compare(first.val, second.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!queue.isEmpty()) {

            ListNode node = queue.poll();

            current.next = node;
            current = current.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head.next;
    }
}
