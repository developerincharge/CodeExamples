package oops.book;
class Book {
    static int totalNoBooks;
   private String title;
   private String author;
   private String isbn;
   boolean isBorrowed;
    static{
        totalNoBooks = 0;
    }
    {
        totalNoBooks++;
    }

   Book(String title, String author, String isbn) {
         this.title = title;
         this.author = author;
         this.isbn = isbn;
   }
   Book(String isbn){
        this( "Unknown", "Unknown",isbn);
   }

   static int getTotalNoBooks(){
        return totalNoBooks;
   }
    void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is already borrowed.");
        }
    }

    void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You have returned: " + title);
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }


    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book book3 = new Book("1984", "George Orwell", "978-0451524935");
        Book book4 = new Book("978-0451524935");

        System.out.println("Total number of books: " + Book.getTotalNoBooks());

        book1.borrowBook();
        book2.borrowBook(); // Trying to borrow again
        book1.returnBook();
        book1.returnBook(); // Trying to return again
        book2.isBorrowed = true;


    }
}
