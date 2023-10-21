package Stack;

class LinkNode<E> {    //链队结点泛型类
    E data;
    LinkNode<E> next;

    public LinkNode() {    //构造方法
        next = null;
    }

    public LinkNode(E d) {    //重载构造方法
        this.data = d;
        this.next = null;
    }
}

public class LinkStackClass<E> {    //链栈泛型类
    LinkNode<E> head;               //存放头结点

    //构造方法
    public LinkStackClass() {
        //TODO: 创建链栈的头结点
        head=new LinkNode<>();
        head.next=null;
    }

    //栈的基本运算算法
    //判断栈是否为空
    public boolean empty() {
        return head.next == null;
    }
    // 元素e入栈
    public void push(E e) {
        //TODO: 元素e入栈（创建新结点s，用头插法将s插到表头）
        LinkNode<E> linkNode = new LinkNode<>(e);
        linkNode.next=head.next;
        head.next=linkNode;
    }
    //出栈操作
    public E pop() {
        if (empty()) {
            throw new IllegalArgumentException("栈空");
        }
        //TODO: 先取出首结点的值，然后删除首结点完成出栈，返回结点值
        E e=(E)head.next.data;
        head.next=head.next.next;
        return e;
    }
    //取栈顶元素操作
    public E peek() {
        if (empty()) {
            throw new IllegalArgumentException("栈空");
        }
        //TODO: 取首结点的值
        return (E) head.next.data;
    }

    @Override
    public String toString() {
        String ans = "";
        if (!empty()) {
            LinkNode<E> p = head.next;
            while (p != null) {
                ans += p.data + " ";
                p = p.next;
            }
        }
        return ans;
    }

    public static LinkStackClass<Integer>resever(LinkStackClass <Integer> sq) {
        int Max = 0;
        int[] a = new int[Max];
        int i = 0;
        while (!sq.empty()) {
            a[i] = sq.pop();
            i++;
        }
        for (int j = 0; j < i; j++) {
            sq.push(a[j]);
        }
        return sq;
    }

    public static void main(String[] args) {
        //测试1
        System.out.println("*******测试1****************");
        String[] a = {"a", "b", "c", "d"};
        //TODO: 使用字符串数组a创建链栈st，在控制台输出进栈元素
        SqStackClass<String> sq1 = new SqStackClass<>();
        for (int i = 0; i < a.length; i++) {
            sq1.push(a[i]);
            System.out.println("进栈元素: " + a[i]);
        }
        //TODO: 将链栈st的所有元素出栈，并在控制台输出所有出栈元素
        System.out.println("*******测试2****************");
        String e;
        while (!sq1.empty()){
            e = sq1.pop();
            System.out.println("出栈元素: " + e);
        }
        //TODO: 判断st是否为空
        System.out.println("sq1为空"+sq1.empty());
    }
}
