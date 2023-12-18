package springtest.springstart;

public class Car {
    String brand;
    String plateNo;
    int year;

    public Car(String brand, String plateNo, int year) {
        this.brand = brand;
        this.plateNo = plateNo;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
