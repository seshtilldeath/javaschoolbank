package me.school.moneytransfer;

public class Fee {
    public double addFee(double value) {
        return value - (value > 1000 ? (value /100) : 0) - 5;
    }
}
