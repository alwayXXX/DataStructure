//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Link;

public class Demo{
    public Demo() {
    }

    public static int Middle1(LinkListClass<Integer> L) {
        int j = 1;
        int n = L.size();

        LinkNode p;
        for(p = L.head.next; j <= (n - 1) / 2; p = p.next) {
            ++j;
        }

        return (Integer)p.data;
    }

    public static void Reverse(LinkListClass<Integer> L) {
        LinkNode<Integer> p = L.head.next;

        LinkNode q;
        for(L.head.next = null; p != null; p = q) {
            q = p.next;
            p.next = L.head.next;
            L.head.next = p;
        }

    }

    public static void move(LinkListClass<Integer> L) {
        LinkNode<Integer> slow = L.head.next;
        LinkNode<Integer> fast = L.head.next;

        while((Integer)fast.data < L.size()) {
            if ((Integer)L.GetElem((Integer)fast.data) < 0) {
                slow = slow.next;
                if (slow != fast) {
                    L.swap((Integer)slow.data, (Integer)fast.data);
                }
            }
        }

    }

    public static LinkListClass<Integer> union(LinkListClass<Integer> L, LinkListClass<Integer> L1) {
        LinkNode<Integer> A = L.head.next;
        LinkNode<Integer> B = L1.head.next;
        LinkListClass<Integer> C = new LinkListClass();
        LinkNode<Integer> t = C.head;

        while(A != null && B != null) {
            if (A.data == B.data) {
                t.next = A;
                A = A.next.next;
                B = B.next.next;
            } else if ((Integer)A.data > (Integer)B.data) {
                B = B.next.next;
            } else {
                A = A.next.next;
            }
        }

        return C;
    }

    public static LinkListClass<Integer> merge(LinkListClass<Integer> L, LinkListClass<Integer> L1) {
        LinkNode<Integer> A = L.head.next;
        LinkNode<Integer> B = L1.head.next;
        LinkListClass<Integer> C = new LinkListClass();
        LinkNode<Integer> t = C.head;

        while(A != null && B != null) {
            if ((Integer)A.data < (Integer)B.data) {
                t.next = A;
                A = A.next.next;
            } else if ((Integer)A.data > (Integer)B.data) {
                t.next = B;
                B = B.next.next;
            } else {
                t.next = A;
                A = A.next.next;
                B = B.next.next;
            }
        }

        return C;
    }

    public static LinkListClass<Integer> different(LinkListClass<Integer> L, LinkListClass<Integer> L1) {
        LinkNode<Integer> A = L.head.next;
        LinkNode<Integer> B = L1.head.next;
        LinkListClass<Integer> C = new LinkListClass();
        LinkNode<Integer> t = C.head;

        while(A != null && B != null) {
            if (A.data != B.data) {
                t.next = A;
                A = A.next.next;
                B = B.next.next;
            } else if ((Integer)A.data > (Integer)B.data) {
                B = B.next.next;
            } else {
                A = A.next.next;
            }
        }

        return C;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5};
        LinkListClass<Integer> linkList = new LinkListClass();
        linkList.CreateListR(a);
        System.out.println(linkList);
        System.out.println(Middle1(linkList));
        Integer[] b = new Integer[]{1, 2, -1, -2, 3, -3, 4};
        LinkListClass<Integer> linklisk1 = new LinkListClass();
        linklisk1.CreateListR(b);
        move(linklisk1);
        System.out.println(linklisk1);
    }
}
