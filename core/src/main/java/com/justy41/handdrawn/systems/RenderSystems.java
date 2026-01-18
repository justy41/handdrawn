package com.justy41.handdrawn.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justy41.handdrawn.components.SpriteRenderer;
import com.justy41.handdrawn.components.TransformComponent;
import com.justy41.handdrawn.core.Ecs;

public class RenderSystems {
    public static void drawTextures(Ecs ecs, SpriteBatch batch) {
        ecs.transforms.forEach((entity, transform) -> {
            SpriteRenderer sr;
            sr = ecs.spriteRenderers.get(entity);

            if(transform != null && sr != null) {
                batch.draw(
                    sr.texture,
                    transform.position.x,
                    transform.position.y,
                    sr.origin.x, sr.origin.y,
                    sr.texture.getWidth(),
                    sr.texture.getHeight(),
                    transform.scale.x,
                    transform.scale.y,
                    transform.rotation,
                    0, 0,
                    sr.texture.getWidth(),
                    sr.texture.getHeight(),
                    sr.flipX,
                    sr.flipY
                );
            }
        });
    }
}
