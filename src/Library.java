import java.util.Scanner;
import java.util.Vector;

public class Library {
    Vector<Book> books;
    Vector<Worker> workers;



    public Library() {
        books=new Vector<Book>();
        workers = new Vector<>();

    }
    public Library(Manger m){
        books=new Vector<Book>();
        workers = new Vector<>();
        workers.add(m);
    }

    public Library(Vector<Book> books, Vector<Integer> prices) {
        this.books = books;

    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +

                '}';
    }

    public boolean addBook(Book b,Worker adder)
    {
        if(this.isWorkinghere(adder)){
            books.add(b);

            return true;
        }
        else {

            return false;
        }


    }

    public int amount() {
        return books.size();
    }

    public int indexOf(int bookCode) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookCode()==bookCode);
            return i;
        }


        return 0;
    }

    public boolean isempty() {
        if (books.size()==0)
            return true;
        else return false;
    }

    public void addWorkerOrManager(Manger m, Worker ToAdd){ //this adds a worker or a manger
        if (m instanceof Manger && !(m instanceof  Adminstrator)){
            if(!(ToAdd instanceof Adminstrator) && this.isWorkinghere(m)){

                workers.add(ToAdd);
                System.out.println("worker added successfully");
            }
            else{
                System.out.println("Cannot add admin with manager privilege");
            }
        }
        else {
            if (this.isWorkinghere(m)) {
                workers.add(ToAdd);
            }
        }

    }

    private boolean isWorkinghere(Worker w){
        for (int i=0;i<workers.size(); i++){
            if(workers.get(i).id==w.id){
                return true;
            }
            else {
                continue;
            }
        }
        return false;
    }


}