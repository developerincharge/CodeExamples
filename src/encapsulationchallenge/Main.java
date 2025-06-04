package encapsulationchallenge;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(50, true); // Initial toner 50%, duplex enabled
        System.out.println("Initial pages count =  " + printer.getPagesPrinted());

        System.out.println("Initial toner level: " + printer.getTonerLevel() + "%");
        System.out.println("Adding 30% toner...");
        int newTonerLevel = printer.addToner(30);
        System.out.println(newTonerLevel != -1 ? "New toner level: " + newTonerLevel + "%" : "Invalid toner amount!");

        int pagesPrinted = printer.printPages(5);
        System.out.printf("Current Job pages :  %d,  Printer Total : %d %n",
                           pagesPrinted, printer.getPagesPrinted());

        pagesPrinted = printer.printPages(10);
        System.out.printf("Current Job pages :  %d,  Printer Total : %d %n",
                          pagesPrinted, printer.getPagesPrinted());


        System.out.println("\nPrinting 10 more pages...");
        pagesPrinted = printer.printPages(10);
        System.out.println("Sheets used: " + pagesPrinted);
        System.out.println("Total pages printed: " + printer.getPagesPrinted());

        System.out.println("\nTrying to overfill toner...");
        int result = printer.addToner(40);
        System.out.println(result == -1 ? "Toner overfill attempt failed." : "Toner level: " + result + "%");
    }


}
