import java.io.*;
import java.util.Vector;

public class Database {
    private Vector<Worker> workers;
    private Vector<Book> books;

    /*
     * Workers Database
     */
    public void fetchWorker() throws IOException {
        workers = new Vector<>();
        BufferedReader reader = new BufferedReader(new FileReader("WorkerDB"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            String id = tokens[0];
            String firstname = tokens[1];
            String lastname = tokens[2];
            workers.add(new Worker(firstname, lastname, id));
        }
        reader.close();
    }
    
    public void addWorker(Worker worker){
        workers.add(worker);

    }

    public Vector getAllWorkers(){
        return workers;
    }

    public Worker searchWorkerById(String id){
        id=id.trim();
        for (int i=0;i<workers.size();i++){
            System.out.println(workers.get(i).getClass());
            if (workers.get(i).ID().equals(id)){
                return workers.get(i);
            }
        }
        return null;
    }
    
    public void saveWorkerToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("WorkerDB"));
            for (Worker worker : workers) {
                String line = worker.ID() + "," + worker.First_Name() + "," + worker.Last_Name() + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving database to file: " + e.getMessage());
        }
    }

    public boolean checkWorkerExistence(Worker worker) {
        String id = worker.ID();
        for (Worker storedWorker : workers) {
            if (id.equals(storedWorker.ID()) && worker.compare(storedWorker)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Books Database
     */
    public void fetchBooks() throws IOException {
        books = new Vector<>();
        BufferedReader reader = new BufferedReader(new FileReader("BookDB"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            String bookCode = tokens[0];
            String title = tokens[1];
            String writer = tokens[2];
            String yearOfpup = tokens[3];
            String numOfPages = tokens[4];
            books.add(new Book(bookCode, title, writer, Integer.parseInt(yearOfpup), Integer.parseInt(numOfPages)));
        }
        reader.close();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Vector getAllBooks() {
        return books;
    }

    public Book searchBookById(String bookCode) {
        bookCode = bookCode.trim();
        for(int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).getClass());
            if (books.get(i).getBookCode().equals(bookCode)) {
                return books.get(i);
            }
        }
        return null;
    }

    public void SaveBookToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("BookDB"));
            for (Book book : books) {
                String line = book.getBookCode() + "," + book.getTitle() + "," + book.getWriter() + ","
                        + book.getYearOfpup() + "," + book.getPrice() + "," + book.getAmount() + ","
                        + book.getNumOfPages();
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving database to file: " + e.getMessage());
        }
    }

    public boolean checkBookExistence(Book book) {
        String bookCode = book.getBookCode();
        for (Book storedBook : books) {
            if (bookCode.equals(storedBook.getBookCode()) && book.compare(storedBook)) {
                return true;
            }
        }
        return false;
    }
    
}
