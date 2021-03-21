package lesson8.entities;

import lesson8.exceptions.SubZeroException;

public class Robot implements Entity{
    private final int maxRun;
    private final int maxJump;
    private final String name;

    public Robot(String name, int maxRun, int maxJump) throws SubZeroException {
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
        return name + " сказал -> Я бегу на механических ногах.";
    }

    @Override
    public String jump() {
        return name + " сказал -> Я прыгаю с помощью механических ног.";
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
        return "Robot{" +
                "maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                ", name='" + name + '\'' +
                '}';
    }
}
