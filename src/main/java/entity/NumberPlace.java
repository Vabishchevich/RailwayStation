package entity;

public class NumberPlace {

    private int numberPlace; //Номер места - номер места в вагоне, на которое продан билет

    public NumberPlace() {
    }

    public NumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    @Override
    public String toString() {
        return "NumberPlace{"
                + "numberPlace=" + numberPlace
                + '}';
    }
}
