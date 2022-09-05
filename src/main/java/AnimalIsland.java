import Entity.AnimalIsland.GameMap;

public class AnimalIsland {

    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        gameMap.startSimulation();
        while (true){
            gameMap.living();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            gameMap.printInfo();
        }

    }
}