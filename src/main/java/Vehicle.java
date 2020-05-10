import java.time.LocalDate;

public abstract class Vehicle {
  private LocalDate startDate;
  private LocalDate endDate;
}

class Car extends Vehicle implements VehicleBehavior {
  private int term;

  @Override
  public int getBoostSpeed() {
    return 400;
  }
}


class Truck extends Vehicle implements VehicleBehavior {
  private String clientName;

  @Override
  public int getBoostSpeed() {
    return 100;
  }
}

interface VehicleBehavior {
  int getBoostSpeed();
}

interface VehicleService {
  <T extends Vehicle> T buildVehicle();
  <T extends Vehicle> T recycleVehicle(T vehicle);
  <T extends Vehicle> void boost(T vehicle);
}

class VehicleServiceImpl implements VehicleService {
  @Override
  public <T extends Vehicle> T buildVehicle() {
    return (T)new Car();
  }

  @Override
  public <T extends Vehicle> T recycleVehicle(T vehicle) {
    return null;
  }

  @Override
  public <T extends Vehicle> void boost(T vehicle) {

  }
}

class LeaseManager {
  private VehicleService vehicleService;

  public LeaseManager(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  public void manage() {
    Truck truck = vehicleService.buildVehicle();
    Vehicle car = vehicleService.buildVehicle();

    vehicleService.recycleVehicle(car);
    vehicleService.recycleVehicle(truck);
  }
}