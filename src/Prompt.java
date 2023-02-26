import java.util.Scanner;

public class Prompt {
    Library lib= Library.getInstance();
    public void TakeID(){

        System.out.println("put your ID:-");
        Scanner In=new Scanner(System.in);
        String ID =In.next();
        Worker w=lib.SearchByID(ID);
        if (w instanceof Worker){
            WorkerPrompt(w);
        } else if (w instanceof  Manger) {
            Manger m=(Manger) w;
            ManagerPrompt(m);
        } else if (w==null) {

            System.out.println("null exception");
        }
        else {
            System.out.println(w instanceof Adminstrator);
            Adminstrator adminstrator =(Adminstrator) w;
            AdminPrompt(adminstrator);
        }
    }
    public void WorkerPrompt(Worker w){
        System.out.println("Your privilages are:-\nadding books\nremoving books\nupdating books' prices");
        System.out.println("What would you like to do");
        Scanner sc=new Scanner(System.in);
    }
    public void ManagerPrompt(Manger manger){
        System.out.println("Your privilages as a manager are:-\nadding books\nremoving books\nupdating books' prices\n" +
                "Hiring and firing workers and managers");
    }
    public void AdminPrompt(Adminstrator adminstrator){
        System.out.println("Your privilages as an Admin are:- \n" +
                "adding books\nremoving books\nupdating books' prices\n"+
                "Hiring and firing workers and managers and admins");
    }
    public void WorkerFuncs(Worker worker,String command){
        command=command.toLowerCase().trim();
        Scanner sc=new Scanner(System.in);
        switch (command){
            case "add": {
                String bookId,bookName,author;
                int numOfPages,yearPubed;

                System.out.println("Enter Book Id");
                bookId=sc.next();
                System.out.println("Enter book name");
                bookName=sc.next();
                System.out.println("Enter book author");
                author=sc.next();
                System.out.println("Enter year published");
                yearPubed =sc.nextInt();
                System.out.println("Enter num of pages");
                numOfPages=sc.nextInt();
                Book b= new Book(bookId,bookName,author,yearPubed,numOfPages);
                worker.addBook(lib,b);
                break;
            }
            case "update price":{
                System.out.println("Enter book Id");
                String id= sc.next();
                worker.Updatebook(id);
                break;
            }
            case "remove":{
                System.out.println("Enter book Id");
                String id= sc.next();
                worker.RemoveBook(id);
                break;
            }
            default:{
                System.out.println("invalid command");
                break;
            }

        }
    }
    public void ManagerFuncs(Manger manager,String command){
        command=command.trim().toLowerCase();
        Scanner sc=new Scanner(System.in);
        switch (command){
            case "add": {
                String bookId,bookName,author;
                int numOfPages,yearPubed;

                System.out.println("Enter Book Id");
                bookId=sc.next();
                System.out.println("Enter book name");
                bookName=sc.next();
                System.out.println("Enter book author");
                author=sc.next();
                System.out.println("Enter year published");
                yearPubed =sc.nextInt();
                System.out.println("Enter num of pages");
                numOfPages=sc.nextInt();
                Book b= new Book(bookId,bookName,author,yearPubed,numOfPages);
                manager.addBook(lib,b);
                break;
            }
            case "update price":{
                System.out.println("Enter book Id");
                String id= sc.next();
                manager.Updatebook(id);
                break;
            }
            case "remove":{
                System.out.println("Enter book Id");
                String id= sc.next();
                manager.RemoveBook(id);
                break;
            }
            case "hire":{
                System.out.println("Enter Worker Id");
                String id= sc.next();
                Worker w= lib.SearchByID(id);
                if(w==null){
                    System.out.println("Worker not found");
                } else if (w.ID()==manager.ID()) {
                    System.out.println("can't hire ones self");
                }
                else{
                    manager.addWorker(w);
                }
                break;
            }
            case "fire":{
                System.out.println("Enter a worker Id");
                String id= sc.next();
                Worker w= lib.SearchByID(id);
                if(w==null){
                    System.out.println("Worker not found");
                } else if (w.ID()==manager.ID()) {
                    System.out.println("can't fire ones self");
                }
                else{
                    manager.Fire(lib,w);
                }
                break;
            }
            default:{
                System.out.println("invalid command");
                break;
            }

        }
    }
    public void AdminFuncs(Adminstrator adminstrator, String command){
        command=command.toLowerCase().trim();
        Scanner sc=new Scanner(System.in);
        switch (command){
            case "add": {
                String bookId,bookName,author;
                int numOfPages,yearPubed;

                System.out.println("Enter Book Id");
                bookId=sc.next();
                System.out.println("Enter book name");
                bookName=sc.next();
                System.out.println("Enter book author");
                author=sc.next();
                System.out.println("Enter year published");
                yearPubed =sc.nextInt();
                System.out.println("Enter num of pages");
                numOfPages=sc.nextInt();
                Book b= new Book(bookId,bookName,author,yearPubed,numOfPages);
                adminstrator.addBook(lib,b);
                break;
            }
            case "update price":{
                System.out.println("Enter book Id");
                String id= sc.next();
                adminstrator.Updatebook(id);
                break;
            }
            case "remove":{
                System.out.println("Enter book Id");
                String id= sc.next();
                adminstrator.RemoveBook(id);
                break;
            }
            case "hire":{
                System.out.println("Enter Worker Id");
                String id= sc.next();
                Worker w= lib.SearchByID(id);
                if(w==null){
                    System.out.println("Worker not found");
                } else if (w.ID()==adminstrator.ID()) {
                    System.out.println("can't hire ones self");
                }
                else{
                    adminstrator.addWorker(w);
                }
                break;
            }
            case "fire":{
                System.out.println("Enter a worker Id");
                String id= sc.next();
                Worker w= lib.SearchByID(id);
                if(w==null){
                    System.out.println("Worker not found");
                } else if (w.ID()==adminstrator.ID()) {
                    System.out.println("can't fire ones self");
                }
                else{
                    adminstrator.Fire(lib,w);
                }
                break;
            }
            default:{
                System.out.println("invalid command");
                break;
            }

        }
    }




}
