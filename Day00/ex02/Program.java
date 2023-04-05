import java.util.Scanner;

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

    public static double sqrt(double numb) {
        
        double t;
        double sqrt = numb / 2;
        
        do {
            t = sqrt;
            sqrt = (t + (numb / t)) / 2;
        } while ((t - sqrt) != 0);
        return sqrt; 
    }

    public static boolean isPrime(int numb) {

        int     i;
        boolean conditions;
        
        if (numb < 2) {
            System.err.println("IllegalArgument");
            conditions = false;
            return conditions;
        }
        else {
            i = 2;
            conditions = true;
            while (i <= sqrt(numb)) {
                if (numb % i == 0) {
                    conditions = false;
                    return conditions;
                }
                i++;
            }
            return conditions;
        }
    }
    static public void main (String[] args) {
     
        int numb;
        int sum;
        int i;

        i = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print(">>> ");
            numb = input.nextInt();
            sum = sumDigits(numb);
            if (isPrime(sum) == true)
                i++;
        } while (numb != 42);
        input.close();
        System.out.println("Count of coffee - request - " + i);
    }
}
