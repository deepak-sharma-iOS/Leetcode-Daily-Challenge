class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>();

        for (int n : nums) {
            numbers.add(n);
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            if (numbers.contains(cur.val)) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return head;
    }
}
