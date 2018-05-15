package entity;

import java.sql.Time; //���������� (subclass) java.util.Date ��� ������ � ����� TIME � ��

public class Train {

    public String numberTrain; //����� ������
    public String startStation; //������� ����������� ������
    public String endStation; //������� �������� ������
    public Time startTime; //����� ����������� ������
    public Time endTime; //����� �������� ������
    private int countPlaces; //���������� ���� � ������

    public Train() {
    }

    public Train(String numberTrain, String startStation, String endStation, Time startTime, Time endTime, int countPlaces) {
        this.numberTrain = numberTrain;
        this.startStation = startStation;
        this.endStation = endStation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.countPlaces = countPlaces;
    }

    public int getCountPlaces() {
        return countPlaces;
    }

    public void setCountPlaces(int countPlaces) {
        this.countPlaces = countPlaces;
    }

    public String getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Train{"
                + "numberTrain='" + numberTrain + '\''
                + ", startStation='" + startStation + '\''
                + ", endStation='" + endStation + '\''
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", countPlaces=" + countPlaces
                + '}';
    }
}
