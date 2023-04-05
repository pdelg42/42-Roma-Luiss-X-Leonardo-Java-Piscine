public class Program {

    public static int sumDigits(int numb) {
        
        int sum;

        sum = 0;
        do {
            sum = sum + numb % 10;
            numb = numb / 10;
            } while (numb > 0);
        return (sum);
    }

    public static void main(String[] args) {
        
        int     numb;
        int     sum;

        numb = 479598;
        sum = sumDigits(numb);
        System.out.println(sum);
    }
}