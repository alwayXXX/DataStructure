package Poly;

public class PolyElem {
    double coef;
    int exp;

    public PolyElem() {
    }

    // 根据系数、指数创建结点

    public PolyElem(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    // 根据polyelem对象创建结点
    public PolyElem(PolyElem elem) {

    }

    public int getExp() {
        return exp;
    }
}
