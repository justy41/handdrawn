package com.justy41.handdrawn.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.justy41.handdrawn.components.Component;
import com.justy41.handdrawn.components.RigidBody;
import com.justy41.handdrawn.components.TransformComponent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ecs {
    int nextEntity;
    private Set<Integer> freeIDs;
    private Set<Integer> entitiesToDestroy;
    public HashMap<Integer, TransformComponent> transforms;
    public HashMap<Integer, RigidBody> rigidbodies;

    public Ecs() {
        nextEntity = -1;
        freeIDs = new HashSet<>();
        entitiesToDestroy = new HashSet<>();
        transforms = new HashMap<>();
        rigidbodies = new HashMap<>();
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
            // ...
            freeIDs.add(entity);
        }

        entitiesToDestroy.clear();
    }
}
