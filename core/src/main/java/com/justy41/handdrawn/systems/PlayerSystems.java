package com.justy41.handdrawn.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.justy41.handdrawn.components.BoxCollider;
import com.justy41.handdrawn.components.RigidBody;
import com.justy41.handdrawn.core.Ecs;

public class PlayerSystems {
    public static void update(Ecs ecs, float deltaTime) {
        ecs.players.forEach((entity, player) -> {
            if(player != null && ecs.rigidbodies.get(entity) != null && ecs.boxColliders.get(entity) != null) {
                RigidBody rb = ecs.rigidbodies.get(entity);
                BoxCollider col = ecs.boxColliders.get(entity);

                if(col.touching.get("down")) {
                    rb.gravity = 1;
                    if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                        rb.velocity.y = player.jumpForce;
                    }
                }
                else {
                    rb.gravity = player.gravity;
                }

                if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                    rb.velocity.x = player.speed;
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                    rb.velocity.x = -player.speed;
                }
                else {
                    rb.velocity.x = 0;
                }

                System.out.println(rb.gravity);
            }
        });
    }
}
