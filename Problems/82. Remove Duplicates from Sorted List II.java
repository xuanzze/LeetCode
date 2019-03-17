public ListNode deleteDuplicates(ListNode head) {
    if (head == null)   return null;
    ListNode dump = new ListNode(0), cur = head, pre = dump;
    dump.next = head;
    while (cur != null) {
        while (cur.next != null && cur.val == cur.next.val)
            cur = cur.next;
        if (pre.next == cur)
            pre = pre.next;
        else
            pre.next = cur.next;
        cur = cur.next;
    }
    return dump.next;
}
