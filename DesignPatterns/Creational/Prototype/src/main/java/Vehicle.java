public abstract class Vehicle implements Cloneable{

    public abstract void start();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
