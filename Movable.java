public interface Movable {

    void move();

    void turnLeft();

    void turnRight();

    void gas(double amount);

    void brake(double amount);

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

}

