import java.time.chrono.IsoChronology;
import java.util.Scanner;
import java.util.Vector;

public class Library {
    Vector<Book> books;
    Vector<Worker> workers;

     static Library library;

    private Library() {
        books=new Vector<Book>();
        workers = new Vector<>();

    }
    private Library(Adminstrator m){
        books=new Vector<Book>();
        workers = new Vector<Worker>();
        workers.add(m);
    }
    public static Library getInstance(){
        Adminstrator adminstrator=new Adminstrator("Juan","Doe","123");
        if (library==null){
            library=new Library(adminstrator);
        }
        Worker w=new Worker("tarek","zoabi","456");
        library.addWorkerOrManager(adminstrator,w);
        return library;
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
        if(this.ContainsWorker(adder)){
            if(!ContainsBook(b.getBookCode())){
                books.add(b);

                return true;
            }
            else {
                for (int i=0; i<books.size();i++){
                    if(b.getBookCode()==books.get(i).getBookCode()){
                        books.get(i).setAmount(books.get(i).getAmount()+1);
                        return true;
                    }
                }
            }


        }
        else {

            return false;
        }


        return false;
    }

    public int amount() {
        return books.size();
    }

    public int indexOf(String bookCode) {
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
            if(!(ToAdd instanceof Adminstrator) && this.ContainsWorker(m)){

                workers.add(ToAdd);
                System.out.println("worker added successfully");
            } else if (m instanceof Adminstrator && this.ContainsWorker(m)) {
                workers.add(ToAdd);
                System.out.println("worker added successfully");
            } else{
                System.out.println("Cannot add admin with manager privilege");
            }
        }
        else {
            if (this.ContainsWorker(m)) {
                workers.add(ToAdd);
            }
        }

    }
    public boolean Fire(Manger m,Worker toFire){
        if(!this.ContainsWorker(toFire)){
            System.out.println("worker does not work in this library");
            return false;
        }
        if(!(toFire instanceof Adminstrator)&& !(toFire instanceof Manger)){
            if( this.ContainsWorker(m)){
                workers.remove(toFire);
                System.out.println("worker removed successfully");
                return true;
            }
            else{
                System.out.println("a worker can  not be removed | unauthorized access");
                return false;
            }
        } else if (m instanceof Adminstrator && this.ContainsWorker(m)) {
            workers.remove(toFire);
            System.out.println("worker removed successfully");
            return true;
        }
        return false;
    }

    private boolean ContainsWorker(Worker w){
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
    private boolean ContainsBook(String bookCode){
        for(int i=0; i<books.size();i++){
            if (bookCode ==books.get(i).getBookCode())
                return true;
        }
        return false;
    }
    public void UpdatePrice(Worker w,Book b, int price){
        if(this.ContainsWorker(w)){
            for(int i=0; i<books.size();i++){
                if (books.get(i).isEqual(b)){
                    books.get(i).setPrice(price);
                    System.out.println("Book price updated successfully");
                    break;
                }
                else {
                    System.out.println("book does not exist in this library");
                }
            }
        }
        else{
            System.out.println("worker does not work here");
        }

    }
    public void RemoveBook(Worker w,Book b){
        if(!this.ContainsWorker(w)){
            System.out.println("Worker doesn't work here");
            return;
        }
        if(this.ContainsWorker(w)) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).isEqual(b)) {
                    books.remove(books.get(i));
                    System.out.println("Book removed successfully");
                    break;
                } else {
                    continue;
                }
            }

        }else {
            System.out.println("Book does not exist in this library");
        }

    }
    public Worker SearchByID(String id){
        id=id.trim();
        for (int i=0;i<workers.size();i++){
            System.out.println(workers.get(i).getClass());
            if (workers.get(i).ID().equals(id)){
                return workers.get(i);
            }
        }
        return null;
    }
    public Book searchbookById(String id){
        for(int i=0; i<books.size();i++){
            if(books.get(i).getBookCode()==id){
                return books.get(i);
            }
        }
        return null;
    }
    public Book SearchBookByName(String name){
        for (int i=0;i< books.size(); i++){
            if(books.get(i).getTitle()==name){
                return books.get(i);
            }
        }
        return null;
    }
    public Worker SearchWorkerByName(String name){
        for (int i=0;i< workers.size(); i++){
            if(workers.get(i).getFullName()==name){
                return workers.get(i);
            }
        }
        return null;
    }


}