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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size =0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(size<k){
            return head;
        }
        // // Step 1: pehle k nodes ka tail dhundo (yahi tera head banega baad mein)
        ListNode tail = head;
        for(int i =1; i<k; i++){
            tail = tail.next;
        }
        ListNode nextGroupHead = tail.next; //k+1 wala node

        // Step 2: sirf pehle k nodes reverse karo
        ListNode newHead = reverseKNodes(head, k);
        
        // Step 3: head ab tail ban gaya, usse next group se jodo (recursion)
        head.next = reverseKGroup(nextGroupHead,k);
        return newHead;
    }
    public ListNode reverseKNodes(ListNode head,int k){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        for(int i=0; i <k; i++){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
