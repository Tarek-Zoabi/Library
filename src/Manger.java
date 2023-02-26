public class Manger extends Worker{
    public Manger(){

    }
    public Manger(String first_name,String last_name,String id){
        this.setId(id);
        this.setId(first_name);
        this.setLastname(last_name);
    }
    public  void addWorker(Worker toAdd){
        Library lib= Library.getInstance();
        if(toAdd instanceof Adminstrator){
            System.out.println("a manager cannot add an admin");
        } else {
            lib.addWorkerOrManager(this,toAdd);
        }
    }
    public void Fire(Library lib,Worker w){
       lib.Fire(this,w);
    }


}
