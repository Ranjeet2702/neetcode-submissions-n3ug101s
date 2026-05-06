/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>heap = new PriorityQueue<>((a,b)->a.val - b.val
        );

        for(ListNode node: lists){
            if(node!=null){
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null){
                heap.offer(node.next);
            }


        }
        return dummy.next;
    }
}
