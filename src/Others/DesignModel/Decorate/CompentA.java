package Others.DesignModel.Decorate;

public class CompentA implements Compent{
    @Override
    public void buildA() {
        System.out.println("CompentA:buildA");
    }

    @Override
    public void buildB() {
        System.out.println("CompentA:buildB");
    }
}
