public class Program {
    public static void main(String[] args) {
        int count;

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Specify a count argument using '--count='");
            System.exit(-1);
        }
        count = Integer.parseInt(args[0].substring(8));
        Thread egg = new Thread(new Egg(count));
        Thread hen = new Thread(new Hen(count));

        try {
    
            if (count <= 0) {
                System.out.println("Incorrect count: " + count);
                System.exit(-1);
            }
            egg.start();
            hen.start();
        }
        catch (NumberFormatException e) {
            System.out.print("Illegal count argument: ");
            System.out.println(e.getMessage());
        }
        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            System.err.println("error");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
