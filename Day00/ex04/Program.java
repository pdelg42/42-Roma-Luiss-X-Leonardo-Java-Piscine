import java.util.Scanner;

public class Program {

    static public void main (String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("-> ");
        String input =  sc.nextLine();
        char arr[] = input.toCharArray();
        int[] unicode = new int[65535];


        // for (char c : arr) {
        //     int count = 0;
        //     for (char p : arr) {
        //         if (c == p && unicode[(int) c] == 0)
        //             count++;
        //         else
        //             continue;
        //     }
        //     if (count != 0)
        //     {    
        //         System.out.println(c + " " + count);
        //         unicode[(int) c] = count;
        //     }
        // }



        String s = "";
        for(int i = 0; i < input.length(); i++)
        {
            unicode[(int) arr[i]] += 1;
        }

        for (int i = 0; i < unicode.length; i++) {
            if (unicode[i] != 0)
                System.out.println( (char) i + " " + unicode[i]);
                // s += (char) i;
        }

    //     int old_max = 9999;
    //     char[] tmp = s.toCharArray();
    //     for (int i = 0; i < tmp.length; i++) 
    //     {
    //         int max = 0;
    //         for (int j = 0; j < tmp.length; j++)
    //         {
    //             int y = unicode[(int) tmp[j]];
    //             if (y > max && y < old_max)
    //             {
    //                 max = y;
    //             }
    //         }
    //         old_max = max;
    //         for (int k = 0; k < unicode.length; k++) {
    //             if (unicode[k] != 0 && unicode[k] == max)
    //                 System.out.println((char)k + " " + unicode[k]);
    //         }
    //     }
    }




}
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
//abbc