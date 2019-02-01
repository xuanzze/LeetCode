public ListNode swapPairs(ListNode head) {
    ListNode dump = new ListNode(0);
    dump.next = head;
    ListNode cur = dump;
    while (cur.next != null && cur.next.next != null) {
        ListNode fst = cur.next, sec = fst.next, trd = sec.next;
        cur.next = sec;
        fst.next = trd;
        sec.next = fst;
        cur = cur.next.next;
    }
    return dump.next;
}
