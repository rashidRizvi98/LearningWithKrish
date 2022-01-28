public class Singleton {

    public static volatile Singleton object;

    private Singleton(){

        if (object!=null)
            throw new RuntimeException("Use getObject");
    }

    public static Singleton getObject(){

        if (object==null){

            synchronized (Singleton.class){

                if (object==null){
                    object=new Singleton();

                }

            }
        }

        return object;
    }
}
