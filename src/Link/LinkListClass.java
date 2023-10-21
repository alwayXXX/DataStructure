//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Link;

import java.io.PrintStream;

public class LinkListClass<E> {
    LinkNode<E> head = new LinkNode();

    public LinkListClass() {
        this.head.next = null;
    }

    private LinkNode<E> geti(int i) {
        LinkNode<E> p = this.head;
        if (i >= 0 && i <= this.size() - 1) {
            for(int k = 0; k < i; ++k) {
                p = p.next;
            }

            return p.next == null ? null : p.next;
        } else {
            throw new IllegalArgumentException("位置i不在有效范围内");
        }
    }

    public void CreateListF(E[] a) {
        for(int i = 0; i < a.length; ++i) {
            E e = (E) a[i];
            LinkNode<E> s = new LinkNode(e);
            s.next = this.head.next;
            this.head.next = s;
        }

    }

    public void CreateListR(E[] a) {
        LinkNode<E> t = this.head;

        for(int i = 0; i < a.length; ++i) {
            LinkNode<E> s = new LinkNode(a[i]);
            t.next = s;
            t = s;
        }

        t.next = null;
    }

    public void Add(E e) {
        LinkNode<E> s = new LinkNode(e);

        LinkNode p;
        for(p = this.head; p.next != null; p = p.next) {
        }

        p.next = s;
    }

    public int size() {
        LinkNode<E> p = this.head;

        int cnt;
        for(cnt = 0; p.next != null; p = p.next) {
            ++cnt;
        }

        return cnt;
    }

    public void Setsize(int nlen) {
        int len = this.size();
        if (nlen >= 0 && nlen <= len) {
            if (nlen != len) {
                LinkNode<E> p = this.geti(nlen - 1);

                assert p != null;

                p.next = null;
            }
        } else {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
    }

    public E GetElem(int i) {
        if (i >= 0 && i <= this.size() - 1) {
            LinkNode<E> p = this.geti(i);

            assert p != null;

            return p.data;
        } else {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
    }

    public void SetElem(int i, E e) {
        if (i >= 0 && i <= this.size() - 1) {
            LinkNode<E> p = this.geti(i);
            p.data = e;
        } else {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
    }

    public int GetNo(E e) {
        LinkNode<E> p = this.head.next;

        int i;
        for(i = 0; p != null && p.data != e; ++i) {
            p = p.next;
        }

        return p == null ? -1 : i;
    }

    public void swap(int i, int j) {
        LinkNode<E> p = this.geti(i);
        LinkNode<E> q = this.geti(j);
        E tmp = p.data;
        p.data = q.data;
        q.data = tmp;
    }

    public void Insert(int i, E e) {
        if (i >= 0 && i <= this.size()) {
            LinkNode<E> s = new LinkNode(e);
            LinkNode<E> p = this.geti(i - 1);
            s.next = p.next;
            p.next = s;
        } else {
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
    }

    public void Delete(int i) {
        assert i < 0;

        assert i > this.size() - 1;

        LinkNode<E> p = this.geti(i - 1);

        assert p != null;

        p.next = p.next.next;
    }

    public String toString() {
        StringBuilder ans = new StringBuilder();

        for(LinkNode<E> p = this.head.next; p != null; p = p.next) {
            ans.append(p.data).append(" ");
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("****************测试1****************");
        Integer[] a = new Integer[]{1, 2, 3, 4, 5};
        LinkListClass<Integer> linkList = new LinkListClass();
        linkList.CreateListR(a);
        System.out.println(linkList);
        linkList.Add(10);
        System.out.println(linkList);

        for(int i = 0; i < linkList.size(); ++i) {
            PrintStream var10000 = System.out;
            Object var10001 = linkList.GetElem(i);
            var10000.print(String.valueOf(var10001) + " ");
        }

        System.out.println();
        System.out.print("重新置长度为5：");
        linkList.Setsize(5);
        System.out.println(linkList);
        int i = 1;
        int x = 20;
        linkList.Insert(i, Integer.valueOf(x));
        System.out.println(linkList);
        i = 3;
        linkList.Delete(i);
        System.out.println(linkList);
        i = 2;
        x = 16;
        linkList.SetElem(i, Integer.valueOf(x));
        System.out.println(linkList.GetNo(5));
        System.out.println();
        System.out.println("****************测试3****************");
        String c = "abcdef";
        LinkListClass<Character> L3 = new LinkListClass();
        L3.CreateListF((Character[])c.chars().mapToObj((ch) -> {
            return (char)ch;
        }).toArray((x$0) -> {
            return new Character[x$0];
        }));
        System.out.println("L3: " + String.valueOf(L3));
    }
}
