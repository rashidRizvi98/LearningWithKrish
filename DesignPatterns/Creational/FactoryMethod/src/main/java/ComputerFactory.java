public class ComputerFactory {

    public Computer createComputer(Type type){

        switch (type){
            case LAPTOP: return new Laptop();
            default: return new Desktop();
        }
    }
}
