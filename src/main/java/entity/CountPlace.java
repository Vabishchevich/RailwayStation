package entity;

public class CountPlace {

    private int countPlace; //Количество мест
    private String typeRailCar; //Тип вагона

    public CountPlace() {
    }

    public CountPlace(int countPlace, String typeRailCar) {
        this.countPlace = countPlace;
        this.typeRailCar = typeRailCar;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(int countPlace) {
        this.countPlace = countPlace;
    }

    public String getTypeRailCar() {
        return typeRailCar;
    }

    public void setTypeRailCar(String typeRailCar) {
        this.typeRailCar = typeRailCar;
    }

    @Override
    public String toString() {
        return "CountPlace{"
                + "countPlace=" + countPlace
                + ", typeRailCar='" + typeRailCar + '\''
                + '}';
    }
}
