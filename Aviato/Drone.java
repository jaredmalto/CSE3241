public class Drone {
    public String name;
    public int modelNumber;
    public double weightCapacity;
    public int serialNumber;
    public int year;
    public String status;
    public String location;
    public double maxSpeed;
    public String warrantyExpirationDate;
    public String activity;
    public String manufacturer;
    public String distanceAutonomy;

    public void setName(String dName) {
        name = dName;
    }

    public void setModelNumber(int mNum) {
        modelNumber = mNum;
    }

    public void setSerialNumber(int serialNum) {
        serialNumber = serialNum;
    }
    public void setStatus(String stat) {
        status = stat;
    }

    public void setYear(int buildYear) {
        year = buildYear;
    }

}
