import java.util.Scanner;

public class Worker implements Person{
    String firstname;
    String lastname;
    String id;
    @Override
    public String First_Name() {
        return this.firstname;
    }

    @Override
    public String Last_Name() {
        return this.lastname;
    }

    @Override
    public String ID() {
        return this.id;
    }
    public  Worker(){

    }

    public Worker(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void addBook(Library lib, Book b){
        if (lib.addBook(b,this)){
            System.out.println("book added");
        }
        else{
            System.out.println("Can't add book. Worker doesn't work in this library");
        }
    }

    public String getFullName(){
        return  First_Name()+" " + Last_Name();
    }
    public void Updatebook(String id){
        Library lb=Library.getInstance();
        System.out.println("Enter book Id");
        Scanner sc =new Scanner(System.in);
        id=sc.next();
        Book toBeUpdated=lb.searchbookById(id);
        System.out.println("Enter new Price");
        int price= sc.nextInt();
        if(price>0 && toBeUpdated!=null){
            lb.UpdatePrice(this,toBeUpdated,price);
        }
        else {
            System.out.println("Price can't be negative or book not found");
        }


    }
    public void RemoveBook(String id){
        Library lb = Library.getInstance();
        Book b=   lb.searchbookById(id);
        if(b!=null){
            lb.RemoveBook(this,b);
        }

    }

    public boolean compare(Worker worker) {
        return this.ID().equals(worker.ID());
    }

}
