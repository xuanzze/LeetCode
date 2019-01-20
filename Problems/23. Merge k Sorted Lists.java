public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
        return null;
    return mergeKLists(lists, 0, lists.length - 1);
}
private ListNode mergeKLists(ListNode[] lists, int start, int end) {
    if (start == end)
        return lists[start];
    int mid = (end - start) / 2 + start;
    ListNode left = mergeKLists(lists, start, mid);
    ListNode right = mergeKLists(lists, mid + 1, end);
    return mergeTwoList(left, right);
}

private ListNode mergeTwoList(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    while (left != null && right != null) {
        if (left.val < right.val) {
            p.next = left;
            left = left.next;
        } else {
            p.next = right;
            right = right.next;
        }
        p = p.next;
    }
    if (left != null) {
        p.next = left;
        return dummy.next;
    }
    p.next = right;
    return dummy.next;
}
