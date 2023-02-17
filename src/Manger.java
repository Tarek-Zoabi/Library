public class Manger extends Worker{
    public  void addWorker(Library lib, Worker toAdd){
        if(toAdd instanceof Adminstrator){
            System.out.println("a manager cannot add an admin");
        } else {
            lib.addWorkerOrManager(this,toAdd);
        }
    }

}
