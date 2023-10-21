package CLink;

class LinkNode<E> {        //循环单链表结点泛型类
    E data;
    LinkNode<E> next;

    public LinkNode() {    //构造方法
        next = null;
    }

    public LinkNode(E d) {     //重载构造方法
        data = d;
        next = null;
    }
}

public class CLinkListClass<E> {    //循环单链表泛型类
    LinkNode<E> head;    //存放头结点

    public CLinkListClass() {        //构造方法
        head = new LinkNode<>();    //创建头结点
        head.next = head;            //置为空的循环单链表
    }

    // 基本运算算法
    private LinkNode<E> geti(int i) {   //返回序号为i的结点
        LinkNode<E> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    //线性表的基本运算算法
    public void CreateListF(E[] a) {    //头插法：由数组a整体建立循环单链表
        LinkNode<E> s;
        for (int i = 0; i < a.length; i++) {    //循环建立数据结点s
            s = new LinkNode<E>(a[i]);  //新建存放a[i]元素的结点s
            s.next = head.next;         //将s结点插入到开始结点之前,头结点之后
            head.next = s;
        }
    }

    public void CreateListR(E[] a) {    //尾插法：由数组a整体建立循环单链表
        LinkNode<E> s, t;
        t = head;            //t始终指向尾结点,开始时指向头结点
        for (int i = 0; i < a.length; i++) {    //循环建立数据结点s
            s = new LinkNode<E>(a[i]);  //新建存放a[i]元素的结点s
            t.next = s;                 //将s结点插入t结点之后
            t = s;
        }
        t.next = head;    //将尾结点的next字段置为head
    }

    public void Add(E e) {    //在线性表的末尾添加一个元素e
        LinkNode<E> s = new LinkNode<E>(e);    //新建结点s
        LinkNode<E> p = head;
        while (p.next != head) {    //查找尾结点p
            p = p.next;
        }
        p.next = s;    //在尾结点之后插入结点s
        s.next = head;
    }

    public int size() {     //求线性表长度
        LinkNode<E> p = head;
        int cnt = 0;
        while (p.next != head) {    //找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void Setsize(int nlen) {    //设置线性表的长度
        int len = size();
        if (nlen < 0 || nlen > len) {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        if (nlen == len) {
            return;
        }
        LinkNode<E> p = geti(nlen - 1);    //找到序号为nlen-1的结点p
        p.next = head;                //将结点p置为尾结点
    }

    public E GetElem(int i) {    //返回线性表中序号为i的元素
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        LinkNode<E> p = geti(i);    //找到序号为i的结点p
        return (E) p.data;
    }

    public void SetElem(int i, E e) {    //设置序号i的元素为e
        if (i < 0 || i > size() - 1) {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        LinkNode<E> p = geti(i);    //找到序号为i的结点p
        p.data = e;
    }

    public int GetNo(E e) {     //查找第一个为e的元素的序号
        int j = 0;
        LinkNode<E> p = head.next;
        while (p != head && !p.data.equals(e)) {
            j++;            //查找元素e
            p = p.next;
        }
        if (p == head) {    //未找到时返回-1
            return -1;
        } else {
            return j;    //找到后返回其序号
        }
    }

    public void Insert(int i, E e) {    //在线性表中序号i位置插入元素e
        if (i < 0 || i > size()) {        //参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        LinkNode<E> s = new LinkNode<E>(e);    //建立新结点s
        LinkNode<E> p = head = geti(i - 1);    //找到序号为i-1的结点p
        s.next = p.next;                    //在p结点后面插入s结点
        p.next = s;
    }

    public void Delete(int i) {            //在线性表中删除序号i位置的元素
        if (i < 0 || i > size() - 1) {    //参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        LinkNode<E> p = geti(i - 1);    //找到序号为i-1的结点p
        p.next = p.next.next;            //删除p结点的后继结点
    }

    @Override
    public String toString() {    //将线性表转换为字符串
        String ans = "";
        LinkNode<E> p = head.next;
        while (p != head) {
            ans += p.data + " ";
            p = p.next;
        }
        return ans;
    }

    public static void main(String[] args)   {
        //测试1
        System.out.println("*******测试1****************“");
        Integer [] a={1,2,3,4,5};
        CLinkListClass<Integer> L1= new CLinkListClass<>();
        L1.CreateListR(a);
        System.out.println("L1: "+L1.toString());
        System.out.println("L1长度="+L1.size());
        System.out.println("末尾添加10");
        L1.Add(10);
        System.out.println("L1: "+ L1);
        System.out.println("求每个序号的元素值");
        for (int i=0;i<L1.size();i++) {
            System.out.println("  序号"+i+"的元素值:"+L1.GetElem(i));
        }
        System.out.println("重新置长度为5");
        L1.Setsize(5);
        System.out.println("L1: "+ L1);
        int i=1;
        int x=20;
        System.out.println("在序号"+i+"位置插入"+x);
        L1.SetElem(i,x);
        System.out.println("L1: "+ L1);
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L1.Delete(i);
        System.out.println("L1: "+ L1);
        i=2; x=16;
        System.out.println("设置序号"+i+"的元素值为"+x);
        L1.SetElem(i,x);
        System.out.println("L1: "+ L1);
        x=5;
        System.out.println("值为"+x+"的元素序号为"+L1.GetNo(x));


        //测试2
        System.out.println();
        System.out.println("*******测试2****************");
        Character [] b={'a','b','c','d','e','f'};
        CLinkListClass<Character> L2=new CLinkListClass<>();
        L2.CreateListR(b);
        System.out.println("L2: "+ L2);
        System.out.println("L2长度="+L2.size());
        L2.Add('x');
        System.out.println("L2: "+ L2);
        System.out.println("求每个序号的元素值");
        for (i=0;i<L2.size();i++) {
            System.out.println("  序号"+i+"的元素值:"+L2.GetElem(i));
        }
        System.out.println("重新置长度为5");
        L2.Setsize(5);
        System.out.println("L2: "+ L2);
        i=1;
        char y='y';
        System.out.println("在序号"+i+"位置插入"+y);
        L2.SetElem(i,y);
        System.out.println("L2: "+ L2);
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L2.Delete(i);
        System.out.println("L2: "+ L2);
        i=2; y='z';
        System.out.println("设置序号"+i+"的元素值为"+y);
        L2.SetElem(i,y);
        System.out.println("L2: "+ L2);
        y='d';
        System.out.println("值为"+y+"的元素序号为"+L2.GetNo(y));

    }
}
