package Stack;

public class exam3_4 {
    public static boolean isMatch(String str){
        int i = 0;
        char e,x;
        SqStackClass<Character> sqStackClass = new SqStackClass<>();
        while (i<str.length()){
            e=str.charAt(i);
            if (e=='('||e=='['||e=='{')
                sqStackClass.push(e);
            else
            {
                if (e == ')') {
                    if (sqStackClass.empty()) return false;
                    if (sqStackClass.peek()!='(') return false;
                    sqStackClass.pop();
                }
                if (e == ']') {
                    if (sqStackClass.empty()) return false;
                    if (sqStackClass.peek()!='[') return false;
                    sqStackClass.pop();
                }
                if (e == '}') {
                    if (sqStackClass.empty()) return false;
                    if (sqStackClass.peek()!='{') return false;
                    sqStackClass.pop();
                }
            }
            i++;
        }
        if (sqStackClass.empty()) {
            return true;
        }else {return false;}
    }

    public static void main(String[] args) {
        System.out.println("测试1");
        String str="([)]";
        if (isMatch(str)) System.out.println(str+"中括号匹配");
        else System.out.println(str+"中括号匹配");
        System.out.println("测试2");
        String str1="([])";
        if (isMatch(str1)) System.out.println(str1+"中括号匹配");
        else System.out.println(str1+"中括号匹配");
    }
}
