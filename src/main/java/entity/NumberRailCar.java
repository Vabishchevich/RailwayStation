package entity;

public class NumberRailCar {

    private int numberRailCar; //����� ������ - ����� ������ � ������

    public NumberRailCar() {
    }

    public NumberRailCar(int numberRailCar) {
        this.numberRailCar = numberRailCar;
    }

    public int getNumberRailCar() {
        return numberRailCar;
    }

    public void setNumberRailCar(int numberRailCar) {
        this.numberRailCar = numberRailCar;
    }

    @Override
    public String toString() {
        return "NumberRailCar{"
                + "numberRailCar=" + numberRailCar
                + '}';
    }
}
