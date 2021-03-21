package lesson8.entities;

import lesson8.exceptions.SubZeroException;

public class Human implements Entity{
    private final int maxRun;
    private final int maxJump;
    private final String name;

    public Human(String name, int maxRun, int maxJump) throws SubZeroException {
        if (maxJump < 0 || maxRun < 0) {
            throw new SubZeroException("Значение препятствия не может быть меньше нуля.");
        }
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        System.out.println(this);
    }

    @Override
    public String run() {
        return name + " сказал -> Мне лень, но я бегу.";
    }

    @Override
    public String jump() {
        return name + " сказал -> Придется прыгнуть...Уф...Прыг...";
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                ", name='" + name + '\'' +
                '}';
    }
}
