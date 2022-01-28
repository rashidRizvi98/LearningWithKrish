public class Main {
    public static void main(String[] args) {

        Singleton singleton=Singleton.getObject();

        Singleton singleton1=Singleton.getObject();

        System.out.println(singleton);
        System.out.println(singleton1);
    }
}
