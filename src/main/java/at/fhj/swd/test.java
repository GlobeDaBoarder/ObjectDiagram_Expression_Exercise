package at.fhj.swd;

public class test {
    public static void main(String[] args) {
        System.out.println(-0.0f );
        System.out.println(-0.0f  * (-1));

        Number pos = new Number(0.0f);
        Negate neg = new Negate(pos);
        System.out.println(neg.evaluate());
        System.out.println(neg.isNegative());
        System.out.println(neg.isPositive());
        System.out.println(-0.0f >= 0);

        //System.out.println(0.0f == -0.0f);
    }

}
