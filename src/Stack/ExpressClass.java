package Stack;

import java.util.*;
import java.lang.*;

public class ExpressClass {    //求表达式值类
    String exp;         //存放中缀表达式
    String postexp = "";    //存放后缀表达式

    public void Setexp(String str) {    //设置exp
        exp = str;
    }

    public String getpostexp() {    //取postexp
        return postexp;
    }

    public void Trans() {   //将算术表达式exp转换成后缀表达式postexp
        Stack<Character> opor = new Stack<>();    //运算符栈
        int i = 0;          //i作为exp的下标
        char ch, e;
        while (i < exp.length()) {  //exp表达式未扫描完时循环
            ch = exp.charAt(i);
            if (ch == '(') {
                opor.push(ch);      //判定为左括号,将左括号进栈
            } else if (ch == ')') { //判定为右括号
                while (!opor.empty() && opor.peek() != '(') {   //将栈中'('之前的运算符退栈并存入postexp
                    e = opor.pop();
                    postexp += e;
                }
                opor.pop();     //将(退栈
            } else if (ch == '+' || ch == '-') {    //判定为加或减号
                while (!opor.empty() && opor.peek() != '(') { //将栈中之前的所有运算符退栈并存入postexp
                    e = opor.pop();
                    postexp += e;
                }
                opor.push(ch);                //再将'+'或'-'进栈
            } else if (ch == '*' || ch == '/') {   //判定为'*'或'/'号
                while (!opor.empty() && opor.peek() != '(' && (opor.peek() == '*' || opor.peek() == '/')) {
                    //将op栈中'('之前的'*'或'/'运算符依次出栈并存放到postexp中
                    e = opor.pop();
                    postexp += e;
                }
                opor.push(ch);  //再将'*'或'/'进栈
            } else {            //处理数字字符
                while (ch >= '0' && ch <= '9') {    //判定为数字
                    postexp += ch;
                    i++;        //将连续的数字放入postexp
                    if (i < exp.length()) {
                        ch = exp.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;            //退一个字符
                postexp += '#'; //用#标识一个数值串结束
            }
            i++;                //继续处理其他字符
        }
        while (!opor.empty()) { //此时exp扫描完毕,栈不空时循环
            e = opor.pop();     //将栈中所有运算符退栈并放入postexp
            postexp += e;
        }
    }

    public double getValue() { //计算后缀表达式postexp的值v
        Stack<Double> opand = new Stack<>();  //运算数栈opand
        double a, b, c, d;
        int i = 0;
        char ch;
        while (i < postexp.length()) {  //扫描postexp串
            ch = postexp.charAt(i);     //从后缀表达式中取一个字符ch
            switch (ch) {
                case '+':               //判定为'+'号
                    a = opand.pop();    //退栈取数值a
                    b = opand.pop();    //退栈取数值b
                    c = b + a;          //计算c
                    opand.push(c);      //将计算结果进栈
                    break;
                case '-':               //判定为'-'号
                    a = opand.pop();    //退栈取数值a
                    b = opand.pop();    //退栈取数值b
                    c = b - a;          //计算c
                    opand.push(c);      //将计算结果进栈
                    break;
                case '*':               //判定为'*'号
                    a = opand.pop();    //退栈取数值a
                    b = opand.pop();    //退栈取数值b
                    c = b * a;          //计算c
                    opand.push(c);      //将计算结果进栈
                    break;
                case '/':               //判定为'/'号
                    a = opand.pop();    //退栈取数值a
                    b = opand.pop();    //退栈取数值b
                    if (a != 0) {
                        c = b / a;      //计算c
                        opand.push(c);  //将计算结果进栈
                    } else {
                        throw new ArithmeticException("运算错误:除零");
                    }
                    break;
                default:    //处理数字字符
                    d = 0;  //将连续的数字符转换成数值存放到d中
                    while (ch >= '0' && ch <= '9') { //判定为数字字符
                        d = 10 * d + (ch - '0');
                        i++;
                        ch = postexp.charAt(i);
                    }
                    opand.push(d);  //将数值d进栈
                    break;
            }
            i++;    //继续处理其他字符
        }
        return opand.peek();    //栈顶元素即为求值结果
    }

    public static void main(String[] args) {
        double v;
        ExpressClass obj = new ExpressClass();
        //String str = "(56-20)/(4+2)";
        String str = "2*(6/3+4)-5";
        obj.Setexp(str);
        System.out.println("中缀表达式: " + str);
        obj.Trans();
        System.out.println("后缀表达式: " + obj.getpostexp());
        System.out.println("求值结果:   " + obj.getValue());

        //String str1 = "2#6#3#/4#+*5#-";
        //int index = str1.indexOf("#");
        //String subStr = str1.substring(0, index);
        //int num = Integer.parseInt(subStr);
        //System.out.println("字符串转数字：" + num);
    }
}
