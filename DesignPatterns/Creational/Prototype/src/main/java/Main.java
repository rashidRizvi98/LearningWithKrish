public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1=VehicleRegistry.getVehicle("car");
        System.out.println(vehicle1);
        vehicle1.start();

        Vehicle vehicle2=VehicleRegistry.getVehicle("car");
        System.out.println(vehicle2);
        vehicle2.start();

        Vehicle vehicle3=VehicleRegistry.getVehicle("van");
        System.out.println(vehicle3);
        vehicle3.start();
    }
}
