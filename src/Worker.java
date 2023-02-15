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
        return lastname;
    }

    @Override
    public String ID() {
        return id;
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

}
