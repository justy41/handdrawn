package com.justy41.handdrawn.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.justy41.handdrawn.components.BoxCollider;
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

    public static void renderTiledMap(Ecs ecs, OrthogonalTiledMapRenderer tiledMapRenderer) {
        ecs.tiledComponents.forEach((entity, tiledComponent) -> {
            if(tiledComponent != null) {
                tiledMapRenderer.setMap(tiledComponent.map);
                tiledMapRenderer.render();
            }
        });
    }

    public static void renderTiledMapLayers(Ecs ecs, OrthogonalTiledMapRenderer tiledMapRenderer, int[] layers) {
        ecs.tiledComponents.forEach((entity, tiledComponent) -> {
            if(tiledComponent != null) {
                tiledMapRenderer.setMap(tiledComponent.map);
                tiledMapRenderer.render(layers);
            }
        });
    }

    public static void debugRender(Ecs ecs, SpriteBatch batch) {
        ecs.boxColliders.forEach((entity, collider) -> {
            if(collider != null) {
                batch.draw(
                    collider.debugTexture,
                    collider.rect.x,
                    collider.rect.y,
                    collider.rect.width,
                    collider.rect.height
                );
            }
        });
    }
}
