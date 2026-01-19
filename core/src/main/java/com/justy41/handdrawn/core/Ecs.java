package com.justy41.handdrawn.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justy41.handdrawn.components.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ecs {
    int nextEntity;
    public SceneManager sceneManager;
    public OrthographicCamera camera;
    private Set<Integer> freeIDs;
    private Set<Integer> entitiesToDestroy;
    public HashMap<Integer, TransformComponent> transforms;
    public HashMap<Integer, RigidBody> rigidbodies;
    public HashMap<Integer, SpriteRenderer> spriteRenderers;
    public HashMap<Integer, BoxCollider> boxColliders;
    public HashMap<Integer, Player> players;
    public HashMap<Integer, TiledComponent> tiledComponents;

    public Ecs() {
        nextEntity = -1;
        freeIDs = new HashSet<>();
        entitiesToDestroy = new HashSet<>();
        transforms = new HashMap<>();
        rigidbodies = new HashMap<>();
        spriteRenderers = new HashMap<>();
        boxColliders = new HashMap<>();
        players = new HashMap<>();
        tiledComponents = new HashMap<>();
        // ...
    }

    public int createEntity() {
        int id;
        if(freeIDs.isEmpty()) {
            nextEntity++;
            id = nextEntity;
        }
        else {
            id = freeIDs.iterator().next();
            freeIDs.remove(id);
        }

        transforms.put(id, null);
        rigidbodies.put(id, null);
        spriteRenderers.put(id, null);
        boxColliders.put(id, null);
        players.put(id, null);
        tiledComponents.put(id, null);
        // ...
        return id;
    }

    public void destroyEntity(int entity) {
        entitiesToDestroy.add(entity);
    }

    public <T extends Component> void addComponent(int entity, HashMap<Integer, T> componentMap, T component) {
        component.key = entity;
        component.enabled = true;
        componentMap.put(entity, component);
    }

    public <T extends Component> void removeComponent(HashMap<Integer, T> componentMap, T component) {
        componentMap.remove(component.key);
    }

    public void processDeletions() {
        for(int entity : entitiesToDestroy) {
            transforms.remove(entity);
            rigidbodies.remove(entity);
            spriteRenderers.remove(entity);
            boxColliders.remove(entity);
            players.remove(entity);
            tiledComponents.remove(entity);
            // ...
            freeIDs.add(entity);
        }

        entitiesToDestroy.clear();
    }

    public void clear() {

    }
}
