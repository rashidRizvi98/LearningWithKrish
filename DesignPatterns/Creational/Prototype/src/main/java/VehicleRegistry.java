import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {

    private static Map<String,Vehicle> vehicles=new HashMap<>();

    static {
        vehicles.put("car",new Car());
        vehicles.put("van",new Van());
    }

    public static Vehicle getVehicle(String vehicleType){
        Vehicle vehicle=null;
        try {
            vehicle= (Vehicle) vehicles.get(vehicleType).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
}
