package DLink;

class DLinkNode<E> {   //双链表结点泛型类
    E data;
    DLinkNode<E> prior; //前驱结点指针
    DLinkNode<E> next;  //后继结点指针

    public DLinkNode() {//构造方法
        prior = null;
        next = null;
    }

    public DLinkNode(E d) { //重载构造方法
        data = d;
        prior = null;
        next = null;
    }
}

// 双链表泛型类
public class DLinkListClass<E> {    //双链表泛型类
    DLinkNode<E> dhead;             //存放头结点
    public DLinkListClass() {       //构造方法
        dhead = new DLinkNode<E>(); //创建头结点
        dhead.prior = null;
        dhead.next = null;
    }

    private DLinkNode<E> geti(int i) { //返回序号为i的结点
        DLinkNode<E> p = dhead;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    //线性表的基本运算算法
    public void CreateListF(E[] a) {   //头插法：由数组a整体建立双链表
        DLinkNode<E> s;
        for (int i = 0; i < a.length; i++) {    //循环建立数据结点s
            s = new DLinkNode<E>(a[i]);         //新建存放a[i]元素的结点s，将其插入到表头
            s.next = dhead.next;                //修改s结点的next字段
            if (dhead.next != null) {           //修改头结点的非空后继结点的prior字段
                dhead.next.prior = s;
            }
            dhead.next = s;     //修改头结点的next字段
            s.prior = dhead;    //修改s结点的prior字段
        }
    }
    public void CreateListR(E[] a) {    //尾插法：由数组a整体建立双链表
        DLinkNode<E> s, t;
        t = dhead;                      //t始终指向尾结点,开始时指向头结点
        for (int i = 0; i < a.length; i++) {    //循环建立数据结点s
            s = new DLinkNode<E>(a[i]); //新建存放a[i]元素的结点s
            t.next = s;                 //将s结点插入t结点之后
            s.prior = t;
            t = s;
        }
        t.next = null;  //将尾结点的next字段置为null
    }

    public void Add(E e) { //在线性表的末尾添加一个元素e
        DLinkNode<E> s = new DLinkNode<E>(e);   //新建结点s
        DLinkNode<E> p = dhead;
        while (p.next != null) {    //查找尾结点p
            p = p.next;
        }
        p.next = s;     //在尾结点之后插入结点s
        s.prior = p;
    }

    public int size() { //求线性表长度
        DLinkNode<E> p = dhead;
        int cnt = 0;
        while (p.next != null) {    //找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void Setsize(int nlen) {     //设置线性表的长度
        int len = size();
        if (nlen < 0 || nlen > len) {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        if (nlen == len) {
            return;
        }
        DLinkNode<E> p = geti(nlen - 1);    //找到序号为nlen-1的结点p
        p.next = null;  //将结点p置为尾结点
    }

    public E GetElem(int i) {   //返回线性表中序号为i的元素
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        DLinkNode<E> p = geti(i);   //找到序号为i的结点p
        return (E) p.data;
    }

    public void SetElem(int i, E e) {  //设置序号i的元素为e
        if (i < 0 || i > size() - 1) {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        DLinkNode<E> p = geti(i);   //找到序号为i的结点p
        p.data = e;
    }

    public int GetNo(E e) {     //查找第一个为e的元素的序号
        int j = 0;
        DLinkNode<E> p = dhead.next;
        while (p != null && !p.data.equals(e)) {
            j++;        //查找元素e
            p = p.next;
        }
        if (p == null) {    //未找到时返回-1
            return -1;
        } else {
            return j;   //找到后返回其序号
        }
    }

    public void Insert(int i, E e) {   //在线性表中序号i位置插入元素e
        if (i < 0 || i > size()) {     //参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        DLinkNode<E> s = new DLinkNode<E>(e);   //建立新结点s
        DLinkNode<E> p = dhead = geti(i - 1); //找到序号为i-1的结点p,其后插入s结点
        s.next = p.next;        //修改s结点的next字段
        if (p.next != null) {   //修改p结点的非空后继结点的prior字段
            p.next.prior = s;
        }
        p.next = s;     //修改p结点的next字段
        s.prior = p;    //修改s结点的prior字段
    }
    public void Delete(int i) {     //在线性表中删除序号i位置的元素
        if (i < 0 || i > size() - 1) {  //参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        DLinkNode<E> p = geti(i);   //找到序号为i的结点p,删除该结点
        p.prior.next = p.next;  //修改p结点的前驱结点的next字段
        if (p.next != null) {   //修改p结点非空后继结点的prior字段
            p.next.prior = p.prior;
        }
    }

    @Override
    public String toString() {     //将线性表转换为字符串
        String ans = "";
        DLinkNode<E> p = dhead.next;
        while (p != null) {
            ans += p.data + " ";
            p = p.next;
        }
        return ans;
    }
    public static void main(String[] args) {
        // 测试1
        // 完成：创建一个双链表，并输出
        System.out.println("****************测试1****************");
        Integer[] a = {1, 2, 3, 4, 5};
        DLinkListClass<Integer> L1 = new DLinkListClass<>();
        L1.CreateListR(a);
        System.out.println("L1: " + L1);
        // 完成：输出链表的长度
        System.out.println("L1长度=" + L1.size());
        // 完成：添加一个值为10的元素
        L1.Add(10);
        System.out.println("L1: " + L1);
        // 完成：在序号1的位置插入值为20的结点
        int i = 1;
        Integer x = 20;
        System.out.println("在序号" + i + "位置插入" + x);
        L1.Insert(i, x);
        System.out.println("L1: " + L1);
        // 完成：删除序号为3的结点
        i = 3;
        System.out.println("删除序号" + i + "的元素");
        L1.Delete(i);
        System.out.println("L1: " + L1);

        System.out.println("求每个序号的元素值");
        for (int j = 0; j < L1.size(); j++)
            System.out.println("  序号" + i + "的元素值:" + L1.GetElem(i));

        System.out.println("重新置长度为5");
        L1.Setsize(5);
        System.out.println("L1: " + L1);

        i = 2;
        x = 16;
        System.out.println("设置序号" + i + "的元素值为" + x);
        L1.SetElem(i, x);
        System.out.println("L1: " + L1);

        x = 5;
        System.out.println("值为" + x + "的元素序号为" + L1.GetNo(x));

        //测试2
        System.out.println();
        System.out.println("****************测试2****************");
        Character[] b = {'a', 'b', 'c', 'd', 'e', 'f'};
        DLinkListClass<Character> L2 = new DLinkListClass<Character>();
        L2.CreateListR(b);
        System.out.println("L2: " + L2);

        System.out.println("L2长度=" + L2.size());

        L2.Add('x');
        System.out.println("L2: " + L2);

        System.out.println("求每个序号的元素值");
        for (i = 0; i < L2.size(); i++)
            System.out.println("  序号" + i + "的元素值:" + L2.GetElem(i));

        System.out.println("重新置长度为5");
        L2.Setsize(5);
        System.out.println("L2: " + L2);

        i = 1;
        Character y = 'y';
        System.out.println("在序号" + i + "位置插入" + y);
        L2.Insert(i, y);
        System.out.println("L2: " + L2);

        i = 3;
        System.out.println("删除序号" + i + "的元素");
        L2.Delete(i);
        System.out.println("L2: " + L2);

        i = 2;
        y = 'z';
        System.out.println("设置序号" + i + "的元素值为" + y);
        L2.SetElem(i, y);
        System.out.println("L2: " + L2);

        y = 'd';
        System.out.println("值为" + y + "的元素序号为" + L2.GetNo(y));
    }
}
