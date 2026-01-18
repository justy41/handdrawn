package com.justy41.handdrawn.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justy41.handdrawn.components.*;
import com.justy41.handdrawn.core.Scene;
import com.justy41.handdrawn.systems.PlayerSystems;
import com.justy41.handdrawn.systems.RenderSystems;
import com.justy41.handdrawn.systems.UpdateSystems;

public class StartScene extends Scene {
    int player;
    int box;

    @Override
    public void start() {
        super.start();

        player = ecs.createEntity();
        ecs.addComponent(player, ecs.transforms, new TransformComponent(0, 0, 1, 1, 0));
        ecs.addComponent(player, ecs.rigidbodies, new RigidBody());
        ecs.addComponent(player, ecs.spriteRenderers, new SpriteRenderer("brick.png"));
        ecs.addComponent(player, ecs.boxColliders, new BoxCollider(0, 0, 16, 16));
        ecs.addComponent(player, ecs.players, new Player(100, 10));

        box = ecs.createEntity();
        ecs.addComponent(box, ecs.transforms, new TransformComponent(200, 200, 1, 1, 0));
        ecs.addComponent(box, ecs.rigidbodies, new RigidBody());
        ecs.addComponent(box, ecs.spriteRenderers, new SpriteRenderer("brick.png"));
        ecs.addComponent(box, ecs.boxColliders, new BoxCollider(200, 200, 16, 16));
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

        RenderSystems.drawTextures(ecs, batch);
    }
}
