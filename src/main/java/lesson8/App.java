package lesson8;

import lesson8.entities.*;
import lesson8.exceptions.SubZeroException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws SubZeroException {

        List<Obstacle> obstacles = new ArrayList<>();
        List<Entity> entities = new ArrayList<>();

            Obstacle wall = new Wall(40);
            Obstacle runningTrack = new RunningTrack(30);

            Entity bender = new Robot("bostomDynamicsModel1",50, 50);
            Entity catBarsik = new Cat("Барсик", 35, 35);
            Entity lazyFry = new Human("Ленивый Фрай", 10, 10);

            obstacles.add(wall);
            obstacles.add(runningTrack);

            entities.add(bender);
            entities.add(catBarsik);
            entities.add(lazyFry);

        System.out.println("===================================================");

        for (Entity entity: entities) {
            for (Obstacle obstacle: obstacles) {
                System.out.println("-----------------------------------------------");
                if (entity.overcomeAnObstacle(obstacle, entity.getMaxJump(), entity.getMaxRun())) {
                    System.out.println("Преодолел препятствие. " + entity);
                } else {
                    System.out.println("Сошел с дистанции. " + entity);
                    break;
                }
            }
        }
    }
}
