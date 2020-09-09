package test;

public class Test1 {

    public static void main(String[] args) {
        Integer a = new Integer(1);

        Integer b = new Integer(1);
        Object c = 1;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a == c);
        System.out.println(a.equals(c));

        System.out.println(c instanceof String);
    }
}
