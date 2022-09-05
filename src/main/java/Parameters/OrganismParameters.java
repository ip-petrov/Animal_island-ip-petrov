package Parameters;


public class OrganismParameters {
    private final int maxCount;
    private final int maxSpeed;

    public OrganismParameters(int maxCount, int maxSpeed) {
        this.maxCount = maxCount;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

}
