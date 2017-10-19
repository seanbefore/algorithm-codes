/**
 * Merge K Sorted Lists(some of the lists maybe empty)
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length,n=1;
        ListNode ln=new ListNode(0);
        ListNode l1,l2;
        if(k==0) return null;
        if(k==1) return lists[0];
        k=(k+1)/2;
        n=2;
        while(k>1){
            for(int i=0;i<k;i++){
                l1=lists[i*n];
                if(i*n+n/2<lists.length)
                    l2=lists[i*n+n/2];
                else break;
                if(l2 == null) continue;
                else{
                   lists[i*n]= mergeTwoLists(l1,l2);
                   l2=lists[i*n+n/2]=null;
                }
            }
            
            k=(k+1)/2;
            n=n*2;
        }
        lists[0]=mergeTwoLists(lists[0],lists[n/2]);
        return lists[0];
    }
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln= new ListNode(0);
        ListNode ln2=ln;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                ln.next=l1;
                l1=l1.next;
                ln=ln.next;
            }else{
                ln.next=l2;
                l2=l2.next;
                ln=ln.next;
            } 
        }
        
        if(l1==null)
            ln.next=l2;
        else
            ln.next=l1;
        
        return ln2.next;
    }
}