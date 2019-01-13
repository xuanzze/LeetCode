class Solution {
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode tail = quickSort2( head );
        head = tail.next;
        tail.next = null;
        return head;
    }
    
    private ListNode quickSort2( ListNode head ){
        ListNode pivot = head, pivotTail = head;
        ListNode left = null, leftTail = null, right = null, rightTail = null;
        
        ListNode current = head.next;
        while( current != null ){
            ListNode next = current.next;
            if( current.val == pivot.val){
                pivotTail.next = current;
                pivotTail = current;
            }else if( current.val < pivot.val ){
                if( left == null ){
                    left = current;                    
                }else{
                    leftTail.next = current;
                }
                leftTail = current;
            }else{
                if( right == null ){
                    right = current;
                }else{
                    rightTail.next = current;
                }
                rightTail = current;
            }
            current = next;
        }
        head = pivot;
        ListNode tail = pivotTail;
        if( left != null ){
            leftTail.next = null;
            leftTail = quickSort2( left );
            head = leftTail.next;
            leftTail.next = pivot;
        }
        if( right != null ){
            rightTail.next = null;
            rightTail = quickSort2( right );
            pivotTail.next = rightTail.next;
            tail = rightTail;
        }
        tail.next = head;
        return tail;
    }
}
