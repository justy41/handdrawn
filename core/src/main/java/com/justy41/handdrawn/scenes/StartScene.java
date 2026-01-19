package com.justy41.handdrawn.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justy41.handdrawn.components.*;
import com.justy41.handdrawn.core.Scene;
import com.justy41.handdrawn.systems.LoadSystems;
import com.justy41.handdrawn.systems.PlayerSystems;
import com.justy41.handdrawn.systems.RenderSystems;
import com.justy41.handdrawn.systems.UpdateSystems;

public class StartScene extends Scene {
    int templateMap;

    @Override
    public void start() {
        super.start();

        // First you need a Tiled map entity (an entity with the TiledComponent)
        templateMap = ecs.createEntity();
        ecs.addComponent(templateMap, ecs.tiledComponents, new TiledComponent("tilemaps/template_map.tmx"));

        // Only after that you can load the objects
        LoadSystems.loadTiledObjects(ecs);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        PlayerSystems.update(ecs, deltaTime);
        UpdateSystems.updatePosition(ecs, deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);

        RenderSystems.renderTiledMap(ecs, tiledMapRenderer);
        RenderSystems.drawTextures(ecs, batch);
    }
}
