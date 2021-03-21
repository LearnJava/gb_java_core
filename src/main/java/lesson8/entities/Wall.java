package lesson8.entities;

import lesson8.exceptions.SubZeroException;

public class Wall implements Obstacle{
    private final int height;

    public Wall(int height) throws SubZeroException {
        if (height >= 0) {
            this.height = height;
            System.out.println(this);
        } else {
            throw new SubZeroException("Значение препятствия не может быть меньше нуля.");
        }
    }

    @Override
    public int getBarrierSize() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
