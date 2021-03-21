package lesson8.entities;

import lesson8.exceptions.SubZeroException;

public class RunningTrack implements Obstacle {
    int length;

    public RunningTrack(int length) throws SubZeroException {
        if (length >= 0) {
            this.length = length;
            System.out.println(this);
        } else {
            throw new SubZeroException("Значение препятствия не может быть меньше нуля.");
        }
    }

    @Override
    public int getBarrierSize() {
        return length;
    }

    @Override
    public String toString() {
        return "RunningTrack{" +
                "length=" + length +
                '}';
    }
}