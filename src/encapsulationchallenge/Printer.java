package encapsulationchallenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {

        this.pagesPrinted = 0;
        // this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1; // -1 invalid tonerLevel
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1; // Invalid toner level
        }

        this.duplex = duplex;
    }

    // Method to add toner to the printer
    public int addToner(int tonerAmount) {

        int tempAmount = tonerAmount + tonerLevel;
        if (tempAmount > 100 || tempAmount < 0) {
            return -1;
        }
        this.tonerLevel += tonerAmount;
        return this.tonerLevel;
    }

    // Method to print pages and calculate sheets used
    public int printPages(int pages) {
        System.out.println("Printing in duplex mode");
        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;

        pagesPrinted += jobPages;
        return jobPages;

    }

        // Getter for pagesPrinted
    public int getPagesPrinted() {
        return pagesPrinted;
    }

      // Getter for tonerLevel
    public int getTonerLevel() {
        return tonerLevel;
    }

      // Getter for duplex
    public boolean isDuplex() {
        return duplex;
    }

}
