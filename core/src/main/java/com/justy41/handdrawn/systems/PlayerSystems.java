package com.justy41.handdrawn.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.justy41.handdrawn.components.RigidBody;
import com.justy41.handdrawn.core.Ecs;

public class PlayerSystems {
    public static void update(Ecs ecs, float deltaTime) {
        ecs.players.forEach((entity, player) -> {
            if(player != null && ecs.rigidbodies.get(entity) != null) {
                RigidBody rb = ecs.rigidbodies.get(entity);

                if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                    rb.velocity.x = player.speed;
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                    rb.velocity.x = -player.speed;
                }
                else {
                    rb.velocity.x = 0;
                }

                if(Gdx.input.isKeyPressed(Input.Keys.W)) {
                    rb.velocity.y = player.speed;
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
                    rb.velocity.y = -player.speed;
                }
                else {
                    rb.velocity.y = 0;
                }
            }
        });
    }
}
