package entity;

public class IdTables {

    private int idRout; //Номер маршрута
    private int idRailCar; //Номер вагона
    private int idDate; //Номер даты

    public IdTables(int idRout, int idRailCar, int idDate) {
        this.idRout = idRout;
        this.idRailCar = idRailCar;
        this.idDate = idDate;
    }

    public IdTables() {
    }

    public int getIdRout() {
        return idRout;
    }

    public void setIdRout(int idRout) {
        this.idRout = idRout;
    }

    public int getIdRailCar() {
        return idRailCar;
    }

    public void setIdRailCar(int idRailCar) {
        this.idRailCar = idRailCar;
    }

    public int getIdDate() {
        return idDate;
    }

    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    @Override
    public String toString() {
        return "IdTables{"
                + "idRout=" + idRout
                + ", idRailCar=" + idRailCar
                + ", idDate=" + idDate
                + '}';
    }
}
