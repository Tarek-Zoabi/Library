import java.util.Vector;

public class Main {
    public static void main(String[] args) {
//        Book book1= new Book(123,"tarek's life","tarek zoabi",2009,465);
//        Book book2=new Book(324,"Lina Mata as a teacher","Lina Mata",2021,247);
//        Book book3=new Book(581,"Messi","Lionel Messi",2022,770);
//        Book book4=new Book(741,"tarek took hashad","Tarek Zoabi",2023,95);
//        Book book5=new Book(100,"How to not take hashad","Alaa Zoabi",2020,421);
//        Vector<Book>books=new Vector<>();
//        Library library=new Library();
//        library.addBook(book2,100);
//        library.addBook(book3,150);
//        library.addBook(book5,403);
//        System.out.println(library);
//
//        System.out.println(library);
//
//        System.out.println(library);
        Book b =new Book(123,"tarek's life","tarek zoabi",2009,465);
        Manger m= new Manger();
        Worker w= new Worker();
        Library l1 =new Library(m);
        Library l2=new Library();
        l1.addWorkerOrManager(m,w);
        w.addBook(l1,b);
        w.addBook(l2,b);
    }

}