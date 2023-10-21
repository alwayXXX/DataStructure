package Poly;

import java.io.*;
import java.util.*;

public class PolyExpClass_finish {
    // 多项式对象
    List<PolyElem> polyExp;

    // 完成：初始画polyExp对象
    public PolyExpClass_finish() {
        this.polyExp = new ArrayList<>();
    }

    // 完成：将结点添加到polyExp表达式的最后
    public void add(PolyElem element) {
        this.polyExp.add(element);
    }

    // 完成：根据系数和指数的数组创建多项式的表达式
    public void createExp(double[] c, int[] e, int n) {
        // 完成：根据系数和指数的数组创建多项式的表达式
        for (int i = 0; i < n; i++) {
            this.polyExp.add(new PolyElem(c[i], e[i]));
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
            PolyElem elem = polyExp.get(i);
            if (elem.coef > 0) {
                sb.append("+");
            }
            if (elem.exp == 0) {
                sb.append(elem.coef);
            } else if (elem.exp == 1) {
                sb.append(elem.coef).append("X");
            } else {
                sb.append(elem.coef).append("X^").append(elem.exp);
            }
        }
        String result = sb.toString();
        if (result.startsWith("+")) {
            result = sb.substring(1);
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
            PolyElem elem1 = l1.polyExp.get(i);
            PolyElem elem2 = l2.polyExp.get(j);
            if (elem1.exp > elem2.exp) {
                //L1的元素的指数较大
                l3.add(new PolyElem(elem1.coef, elem1.exp));
                i++;
            } else if (elem1.exp < elem2.exp) {
                //L2的元素的指数较大
                l3.add(new PolyElem(elem2.coef, elem2.exp));
                j++;
            } else {
                //l1和l2的元素的指数相等
                double coef = elem1.coef + elem2.coef;
                if (coef != 0) {
                    l3.add(new PolyElem(coef, elem1.exp));
                }
                i++;
                j++;
            }
        }
        // 3. 判断l1、l2是否已经遍历完，没有就把剩余的元素增加到l3的后面
        while(i < l1.polyExp.size()) {
            l3.add(new PolyElem(l1.polyExp.get(i)));
            i++;
        }
        while(j < l2.polyExp.size()) {
            l3.add(new PolyElem(l2.polyExp.get(j)));
            j++;
        }
        return l3;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 重定向标准输入、输出流
        System.setIn(new FileInputStream("resources/abc.in"));
        System.setOut(new PrintStream("resources/abc.out"));
        Scanner scanner = new Scanner(System.in);

        // 2. 初始化
        PolyExpClass exp1 = new PolyExpClass();
        PolyExpClass exp2 = new PolyExpClass();
        double[] coefs = new double[100];
        int[] exps = new int[100];
        int n;

        // 3. 读取abc.in文件中的数据，创建多项式exp1和exp2
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            coefs[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            exps[i] = scanner.nextInt();
        }
        exp1.createExp(coefs, exps, n);
        System.out.println("第1个多项式：" + exp1);

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            coefs[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            exps[i] = scanner.nextInt();
        }
        exp2.createExp(coefs, exps, n);
        System.out.println("第2个多项式：" + exp2);

        // exp1和exp2的排序
        exp1.sort();
        System.out.println("第1个多项式排序后：" + exp1);
        exp2.sort();
        System.out.println("第2个多项式排序后：" + exp2);
        // 多项式相加，并输出结果
        PolyExpClass exp3 = PolyExpClass.add(exp1, exp2);
        System.out.println("两个多项式相加：" + exp3);
    }

    public static void readFile(String filename) throws IOException {
        InputStream input = PolyElem.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(input)));
        PolyExpClass exp1 = new PolyExpClass();
        PolyExpClass exp2 = new PolyExpClass();
        double[] coefs = new double[100];
        int[] exps = new int[100];
        int n = Integer.parseInt(reader.readLine());

    }
}
