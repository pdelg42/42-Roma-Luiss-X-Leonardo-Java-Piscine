import java.util.Scanner;

public class Program {

    public static double sqrt(double numb) {
        
        double t;
        double sqrt = numb / 2;
        
        do {
            t = sqrt;
            sqrt = (t + (numb / t)) / 2;
        } while ((t - sqrt) != 0);
        return sqrt; 
    }

    public static void isPrime(int numb) {

        int     i;
        int     count;
        boolean conditions;
        
        if (numb < 2) {
            System.err.println("IllegalArgument");
            return ;
        }
        else {
            i = 2;
            count = 1;
            conditions = true;
            while (i <= sqrt(numb)) {
                if (numb % i == 0) {
                    conditions = false;
                    System.out.println(conditions + " " + count);
                    return ;
                }
                i++;
                count++;  
            }
            System.out.println(conditions + " " + count);
        }
    }

    public static void main(String[] args) {

        int numb;

        Scanner input = new Scanner(System.in);
        System.out.println("Insert Coin: ");
        numb = input.nextInt();
        input.close();
        isPrime(numb); 
    }
}
