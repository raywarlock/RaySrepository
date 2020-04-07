import org.testng.annotations.Test;

public class Day1 {
    @Test
    public void testFirst001() {
        System.out.println("Hell o World");
    }

    @Test
    public void test002() {
        String s1 = "Who let the dogs out?";        // String object stored in heap memory
// Just using "" creates a string, so no need to write it the previous way.
        String s2 = "Who who who who!";                         // String literal stored in String pool
// Java defined the operator + on strings to concatenate:
        char space;
        space = ' ';
        String s3 = s1 + space + s2;
        System.out.println(s3);
    }

    @Test
    public void testNumber() {
        int num;
        num = 5;
        String s = "I have " + num + " cookies";
        System.out.println(s);
    }

    @Test
    public void testBoolean() {
        int a = 6;
        int b = 37;
        boolean m = (a*6 == b);
        if (m)
        System.out.println("Все верно");
        else
            System.out.println("АшыПкА");
    }

}
