public class Main {
    public static void main(String[] args) {

        ComputerFactory computerFactory=new ComputerFactory();
        Computer computer1=computerFactory.createComputer(Type.DESKTOP);
        Computer computer2=computerFactory.createComputer(Type.LAPTOP);

        computer1.shutDown();
        computer2.shutDown();
    }
}
