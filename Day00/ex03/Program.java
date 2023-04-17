import java.util.Scanner;

public class Program {

	public static int getMin(Scanner input) {

		int 	vote;
		int		i;
		int		min;

		System.out.print(" >>> ");
		i = 0;
		min = 10;
		while (i++ < 5) {
			vote = input.nextInt();
			if (vote < min)
				min = vote;
			if (vote < 1 || vote > 9)
				handlerErr();
			if (i == 5) {
				return (min);
			}
		}
		return (min);
	}

	public static void printing(long builded, int nWeek) {

		long	reverse;
		long	numb;
		long	temp;
		int		i;

		reverse = 0;
		temp = builded;
		while (temp != 0) {
			numb = temp % 10;
			reverse = reverse * 10 + numb;
			temp /= 10;
		}
		nWeek = 1;
		do {
			numb = reverse % 10;
			i = 0;
			System.out.print("Week ");
			System.out.print(nWeek);
			System.out.print(" ");
			while (i++ < numb)
				System.out.print("=");
			System.out.println(">");
			reverse = reverse / 10;
		} while (reverse > 0 && ++nWeek > 0);
	}

	public static void handlerErr() {

		System.err.println("IllegalArgument");
		System.exit(-1);
	}

	public static void main(String[] args) {

		String	week;
		int		MAX_WEEKS = 18;
		int		min;
		int		nWeek;
		int		i;
		long	builded;

		Scanner input = new Scanner(System.in);
		i = 0;
		min = 0;
		nWeek = 0;
		builded = 0;
		while (i++ < MAX_WEEKS) {
			System.out.print(">>> ");
			week = input.next();
			if (week.equals("Week")) {
				nWeek = input.nextInt();
				if (nWeek == i) {
					min = getMin(input);
					builded = builded * 10 + min;
				}
				else
					handlerErr();
			}
			else if (week.equals("42")) {
				printing(builded, nWeek);
				System.exit(1);
			}
			else
				handlerErr();
		}
		printing(builded, nWeek);
	}
}
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42