public class Program {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("Use '--count='");
            System.exit(-1);
        }
        try {
            
            int count = Integer.parseInt(args[0].substring(8));
            if (count <= 0) {
                System.out.println("Incorrect count: " + count);
                System.exit(-1);
            }
            int queue = 0;
            Thread egg = new Thread(new Egg(count, queue));
            Thread hen = new Thread(new Hen(count, queue));
            egg.start();
            hen.start();
        }
        catch (NumberFormatException e) {
            System.out.print("Illegal count argument: ");
            System.out.println(e.getMessage());
        }
    }
}
