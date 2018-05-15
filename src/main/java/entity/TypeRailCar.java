package entity;

public class TypeRailCar {

    private String typeRailCar; //Тип вагона
    private String numberPassport; //Номер паспорта

    public TypeRailCar() {
    }

    public TypeRailCar(String typeRailCar, String numberPassport) {
        this.typeRailCar = typeRailCar;
        this.numberPassport = numberPassport;
    }

    public String getTypeRailCar() {
        return typeRailCar;
    }

    public void setTypeRailCar(String typeRailCar) {
        this.typeRailCar = typeRailCar;
    }

    public String getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    @Override
    public String toString() {
        return "TypeRailCar{"
                + "typeRailCar='" + typeRailCar + '\''
                + ", numberPassport='" + numberPassport + '\''
                + '}';
    }
}
