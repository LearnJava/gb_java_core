package lesson8.entities;

public interface Entity {
    String run();

    String jump();

    //    boolean overcomeAnObstacle(Obstacle obstacle);
    default boolean overcomeAnObstacle(Obstacle obstacle, int maxJump, int maxRun) {
        if (obstacle instanceof Wall) {
            if (obstacle.getBarrierSize() <= maxJump) {
                System.out.println(jump());
                return true;
            } else {
                System.out.println("Такую высоту я перепрыгнуть не могу.");
                return false;
            }
        } else if (obstacle instanceof RunningTrack) {
            if (obstacle.getBarrierSize() <= maxRun) {
                System.out.println(run());
                return true;
            } else {
                System.out.println("Такую дистанцию я пробежать не могу.");
                return false;
            }
        }
        return false;
    }

    int getMaxRun();
    int getMaxJump();
}
