package entity;

public class NumberTrain {

    private String numberTrain; //����� ������

    public NumberTrain() {
    }

    public String getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    @Override
    public String toString() {
        return "NumberTrain{"
                + "numberTrain='" + numberTrain + '\''
                + '}';
    }
}
