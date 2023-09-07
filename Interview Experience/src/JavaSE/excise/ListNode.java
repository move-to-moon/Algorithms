package JavaSE.excise;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val)
    { this.val = val; }

    ListNode(int val, ListNode next)
    { this.val = val; this.next = next; }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        head1.next = listNode1 ;

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(5);


        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(head1, head2);

        for (int i = 0 ;i < 4 ;i++){
            System.out.println(listNode.val);
            listNode = listNode.next ;
        }


    }
}




class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head  = new ListNode(0);
        ListNode listNode = head ;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1 ;
                head = head.next;
                list1 = list1.next ;
            }else {
                head.next = list2 ;
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 == null && list2 != null){
            head.next = list2 ;

        }else {
            head.next = list1 ;
        }

        return listNode.next;




    }
}


