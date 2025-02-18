package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;
    private final Random random = new Random();

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        // Spawn enemy at a random location
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-10, -10, 20, 0, -10, 10);

        // Random spawn location within game screen bounds
        enemyShip.setX(random.nextInt(gameData.getDisplayWidth()));
        enemyShip.setY(random.nextInt(gameData.getDisplayHeight()));

        enemyShip.setRadius(8);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
