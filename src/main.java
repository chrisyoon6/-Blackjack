import java.util.Scanner;

public class main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        BlackjackTable table = new BlackjackTable(scan);
        table.start();
    }

}
