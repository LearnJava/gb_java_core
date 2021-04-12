package lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int ROAD_LENGTH_1 = 50;
    public static final int ROAD_LENGTH_2 = 90;
    public static final int CARS_COUNT = 4;
    public static final int TUNNEL_LENGTH = 30;

    public static void main(String[] args) {
        CyclicBarrier readiness = new CyclicBarrier(CARS_COUNT + 1);
        CountDownLatch allFinish = new CountDownLatch(CARS_COUNT);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(allFinish, new Road(ROAD_LENGTH_1), new Tunnel(TUNNEL_LENGTH), new Road(ROAD_LENGTH_2));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            new Thread(new Car(readiness, race, 20 + (int) (Math.random() * 10))).start();
        }

        try {
            readiness.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            allFinish.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

class Car implements Runnable {
    private static int CARS_COUNT;
    private final CyclicBarrier readiness;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CyclicBarrier readiness, Race race, int speed) {
        this.readiness = readiness;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            readiness.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        race.finish(this);
    }
}

class Race {
    private final ArrayList<Stage> stages;
    private final Lock lock;
    private final CountDownLatch allFinish;
    private boolean haveWinner;
    private final Set<Car> finishedCars;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(CountDownLatch allFinish, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.lock = new ReentrantLock();
        this.allFinish = allFinish;
        this.finishedCars = new HashSet<>();
    }

    public void finish(Car car) {
        try {
            lock.lock();
            if (finishedCars.contains(car)) {
                return;
            }
            finishedCars.add(car);
            System.out.println("Финишировал " + car.getName());
            if (!haveWinner) {
                haveWinner = true;
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель " + car.getName());
            }
            allFinish.countDown();
        } finally {
            lock.unlock();
        }
    }
}

class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Трасса  " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 700L);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car c);
}

class Tunnel extends Stage {

    private final Semaphore sem;

    public Tunnel(int tunnelLength) {
        this.length = tunnelLength;
        this.description = "Тоннель длинной " + length + " метров";
        this.sem = new Semaphore(MainClass.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sem.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 700L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}