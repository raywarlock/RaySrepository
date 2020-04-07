import org.testng.annotations.Test;

public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int length = numbers[2];
        char[] chars = new char[length];
        chars[numbers.length -1] = 'y';
        System.out.println(chars[2]);
    }
}
