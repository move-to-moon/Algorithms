package Test;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pretemp = head ;
        ListNode temp = head.next;
        //这里会出现最后一个节点无法处理的问题
        while (temp.next != null) {
            if (temp.val != pretemp.val) {
                pretemp = pretemp.next;
                temp = temp.next;
            } else {
                temp = temp.next;
                pretemp.next = temp;
            }
        }

        if (temp.val == pretemp.val){
            temp.next = null;
        }

        return head;
    }


    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;



        if (list1.val > list2.val){
           list2.next = mergeTwoLists(list1,list2.next);
           return list2;
        }else {
          list1.next=mergeTwoLists(list1.next,list2);
          return list1;
        }



    }
}

class Solution {
    //通过快慢指针来解决，类似于你要删除中间元素的题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个伪节点，用于返回结果
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        //定义一个快指针,指向伪节点，用于遍历链表
        ListNode prev = dumpy;
        //定一个慢指针，
        ListNode tail = dumpy;
        //让快指针先移动 n 步
        while (n > 0) {
            prev = prev.next;
            n--;
        }
        //只要快指针不指向空，就继续循环
        while (prev.next != null) {
            //让快慢指针同时移动
            tail = tail.next;
            prev = prev.next;
        }
        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        tail.next = tail.next.next;
        //返回为指针指向的头节点
        return dumpy.next;
    }




    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}