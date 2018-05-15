package entity;

import java.sql.Time;

public class Ticket {

    private Rout rout; //Маршрут, список маршрутов по которым проходит поезд
    private String numberTrain; //Номер поезда
    private String passportNumber; //Номер паспорта
    private String wagonClass; //Тип вагона (св, плацкарт)
    private Time startTime; //Время отправления - время, в которое пассажир садится на поезд
    private Time endTime; //Время прибытия - время, в которое пассажир сходит с поезда
    private int numberRailCar; //Номер вагона - номер вагона в поезде
    private int numberPlace; //Номер места - номер места в вагоне, на которое продан билет
    private int idTicket; //Номер бланка - уникальный номер билета

    public Ticket() {
    }

    public Ticket(Rout rout, String numberTrain, String wagonClass, String passportNumber, Time startTime, Time endTime, int numberPlace, int numberRailCar, int idTicket) {
        this.rout = rout;
        this.numberTrain = numberTrain;
        this.wagonClass = wagonClass;
        this.passportNumber = passportNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberPlace = numberPlace;
        this.numberRailCar = numberRailCar;
        this.idTicket = idTicket;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Rout getRout() {
        return rout;
    }

    public String getNumberTrain() {
        return numberTrain;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getWagonClass() {
        return wagonClass;
    }

    public void setRout(Rout rout) {
        this.rout = rout;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setWagonClass(String wagonClass) {
        this.wagonClass = wagonClass;
    }

    public int getNumberRailCar() {
        return numberRailCar;
    }

    public void setNumberRailCar(int numberRailCar) {
        this.numberRailCar = numberRailCar;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public String toString() {
        return "Ticket{"
                + "rout=" + rout
                + ", numberTrain='" + numberTrain + '\''
                + ", passportNumber='" + passportNumber + '\''
                + ", wagonClass='" + wagonClass + '\''
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", numberRailCar=" + numberRailCar
                + ", numberPlace=" + numberPlace
                + ", idTicket=" + idTicket
                + '}';
    }
}
