
import java.util.Scanner;

public class Program {

    static public void main (String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("-> ");
        String input =  sc.nextLine();
        char arr[] = input.toCharArray();
        int[] unicode = new int[65535];

        String s = "";
        for(int i = 0; i < input.length(); i++)
        {
            unicode[(int) arr[i]] += 1;
        }

        for (int i = 0; i < unicode.length; i++)
        {
            if (unicode[i] != 0)
                s += (char) i;
        }

        prova(s, unicode);
    }

    static void prova(String s, int[] unicode)
    {
        int idx_lett = 0;
        int old_max = 9999;
        char[] tmp = s.toCharArray();

        int len = 10;
        if (tmp.length < 10)
        {
            len = tmp.length;
        }
        char[] lettere = new char[len];
        int[] numeri = new int[len];
        for (int i = 0; i < len ; i++) 
        {
            int max = 0;
            for (int j = 0; j < tmp.length; j++)
            {
                int y = unicode[(int) tmp[j]];
                if (y > max && y < old_max)
                {
                   max = y;
                }
            }
            old_max = max;
    
            for (int k = 0; k < unicode.length && idx_lett < 10; k++)
            {
                if (unicode[k] != 0 && unicode[k] == max)
                {
                    lettere[idx_lett] = (char) k;
                    numeri[idx_lett++] = unicode[k];
                }
            }
        }
    
        stampa(lettere, numeri);
    }



    static private void stampa(char[] lettere, int[] nums)
    {
        float divider = 1;
        if (nums[0] > 10)
        {
            divider = nums[0] / 10.0f;
        }
        
        int level = 11;
        for (int i = 0; i < level; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                int x = (int)(nums[j] / divider);
                if (x > level - i - 1)
                {
                    System.out.print(" # ");
                }
                if (x == level - i - 1)
                {
                    if (nums[j] < 10)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(nums[j] + " ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < lettere.length; i++)
        {
            System.out.print(" " + lettere[i] + " ");
        }

    }


}
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42
//abbc