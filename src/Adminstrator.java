public class Adminstrator extends Manger{
    public void addWorker(Library lib,Worker w){
        lib.addWorkerOrManager(this,w);
    }
}
