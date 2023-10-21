package Poly;

import java.io.*;
import java.util.*;

public class PolyExpClass {
    // 多项式对象
    List<PolyElem> polyExp;

    // 完成：初始化polyExp对象
    public PolyExpClass() {
        polyExp = new ArrayList<>();
    }

    // 将结点添加到polyExp表达式的最后
    public void add(PolyElem element) {
        this.polyExp.add(element);
    }

    // 完成：根据系数和指数的数组创建多项式的表达式
    public void createExp(double[] c, int[] e, int n) {
        for (int i = 0; i < n; i++) {
            this.polyExp.add(new PolyElem(c[i],e[i]));
        }
    }

    public void sort() {
        this.polyExp.sort(Comparator.comparing(PolyElem::getExp).reversed());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // 完成：遍历list，将表达式输出为：2X^3+3.2X^5-6X+10
        for (int i = 0; i < polyExp.size(); i++) {
            PolyElem p=polyExp.get(i);
            if (p.coef > 0){
                sb.append("+");
            }
            if (p.exp == 0){
                sb.append(p.coef);
            } else if (p.exp == 1) {
                sb.append(p.coef).append("x");
            }else {
                sb.append(p.coef).append("x^").append(p.exp);
            }
        }
        String result = sb.toString();
        if (result.startsWith("+")){
            result = result.substring(1);
        }
        return result;
    }

    public static PolyExpClass add(PolyExpClass l1, PolyExpClass l2) {
        // 1. 初始化
        PolyExpClass l3 = new PolyExpClass();
        int i = 0, j = 0;
        // 2. 遍历顺序表，完成多项式的相加
        // 思路：
        // l1的元素的指数较大，则添加由l1元素创建的结点
        // l2的元素的指数较大，则添加由l2元素创建的结点
        // l1和l2的元素的指数相等，则将l1和l2的系数相加后创建新结点
        while (i < l1.polyExp.size() && j < l2.polyExp.size())  {
        }
        // 3. 判断l1、l2是否已经遍历完，没有就把剩余的元素增加到l3的后面

        return l3;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 1. 重定向输入、输出流
        System.setIn(new FileInputStream("resources/abc.in"));
        System.setOut(new PrintStream("resources/abc.out"));
        Scanner scanner = new Scanner(System.in);

        // 2. 初始化
        PolyExpClass exp1 = new PolyExpClass();
        PolyExpClass exp2 = new PolyExpClass();
        double[] coefs = new double[100];
        int[] exps = new int[100];
        int n;

        // 完成： 读取abc.in文件中的数据，创建多项式exp1和exp2


        // 完成：exp1和exp2的排序

        // 完成：多项式相加，并输出结果
    }

}
