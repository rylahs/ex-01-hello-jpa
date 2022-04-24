package hellojpa;

public class ValueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = a;

        b = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);


        Integer c = new Integer(20);
        Integer d = c;


        int q = 10;
        int w = 10;
        System.out.println(" q == w :  " + (q == w));

        Address address1 = new Address("A", "B", "C");
        Address address2 = new Address("A", "B", "C");

        System.out.println("address1 == address2 : " + (address1 == address2));
        System.out.println("address1 = " + address1.getClass());
        System.out.println("address1 = " + address2.getClass());
        System.out.println("address1 = " + address1.equals(address2));
    }
}
