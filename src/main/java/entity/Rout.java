package entity;

public class Rout {

    private String startStation; //Станция отправления
    private String endStation; //Станция прибытия
    private String startDate; //Дата отправления

    public Rout() {
    }

    public Rout(String startStation, String endStation, String startDate) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.startDate = startDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rout)) {
            return false;
        }

        Rout that = (Rout) o;

        if (startStation != null ? !startStation.equals(that.startStation) : that.startStation != null) {
            return false;
        }
        if (endStation != null ? !endStation.equals(that.endStation) : that.endStation != null) {
            return false;
        }
        return !(startDate != null ? !startDate.equals(that.startDate) : that.startDate != null);

    }

    @Override
    public int hashCode() {
        int result = startStation != null ? startStation.hashCode() : 0;
        result = 31 * result + (endStation != null ? endStation.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rout{"
                + "startStation='" + startStation + '\''
                + ", endStation='" + endStation + '\''
                + ", startDate=" + startDate
                + '}';
    }
}
