package Stack;

import java.lang.*;

public class SqStackClass<E> {      //顺序栈泛型类
    final int initcapacity = 10;    //顺序栈的初始容量(常量)
    private int capacity;    //存放顺序栈的容量
    private E[] data;       //存放顺序栈中元素
    private int top;        //存放栈顶指针

    public SqStackClass() {    //构造方法，实现data和size的初始化
        data = (E[]) new Object[initcapacity];    //强制转换为E类型数组
        capacity = initcapacity;
        top = -1;
    }

    private void updatecapacity(int newcapacity) {    //改变顺序栈的容量为newcapacity
        E[] newdata = (E[]) new Object[newcapacity];
        for (int i = 0; i < top; i++) {    //复制原来的元素
            newdata[i] = data[i];
        }
        capacity = newcapacity;    //设置新容量
        data = newdata;            //仍由data标识数组
    }

    //栈的基本运算算法
    public boolean empty() {    //判断栈是否为空
        return top == -1;
    }

    public void push(E e) {    //元素e进栈
        if (top == capacity - 1) {    //顺序栈空间满时倍增容量
            updatecapacity(2 * (top + 1));
        }
        top++;            //栈顶指针增1
        data[top] = e;
    }

    public E pop() {    //出栈操作
        if (empty()) {
            throw new IllegalArgumentException("栈空");
        }
        E e = (E) data[top];
        top--;
        if (top + 1 > initcapacity && top + 1 == capacity / 4) {    //满足条件则容量减半
            updatecapacity(capacity / 2);
        }
        return e;
    }

    public E peek() { //取栈顶元素操作
        if (empty()) {
            throw new IllegalArgumentException("栈空");
        }
        return (E) data[top];
    }

    @Override
    public String toString() { //将栈转换为字符串,不是基本运算，仅仅调试用
        String ans = "";
        for (int i = 0; i <= top; i++) {
            ans += data[i] + " ";
        }
        return ans;
    }

    public static void main(String[] args) {
        //测试1
        System.out.println("*******测试1****************");
        Integer[] a = {1, 2, 3, 4, 5};
        SqStackClass<Integer> st1 = new SqStackClass<>();
        for (int i = 0; i < a.length; i++) {
            st1.push(a[i]);
            System.out.println("进栈元素: " + a[i]);
        }
        System.out.println("st1为空: " + st1.empty());
        Integer e;
        while (!st1.empty()) {
            e = st1.pop();
            System.out.println("出栈元素: " + e);
        }
        System.out.println("st1: " + st1);
        System.out.println("st1为空: " + st1.empty());

        //测试2
        System.out.println("*******测试2****************");
        String[] b = {"a", "b", "c", "d"};
        SqStackClass<String> st2 = new SqStackClass<>();
        for (int i = 0; i < b.length; i++) {
            st2.push(b[i]);
            System.out.println("进栈元素: " + b[i]);
        }
        System.out.println("st2为空: " + st2.empty());
        String x;
        while (!st2.empty()) {
            x = st2.pop();
            System.out.println("出栈元素: " + x);
        }
        System.out.println("st2: " + st2);
        System.out.println("st2为空: " + st2.empty());
    }
}
