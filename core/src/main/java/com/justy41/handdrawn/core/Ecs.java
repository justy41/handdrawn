package com.justy41.handdrawn.core;

import com.justy41.handdrawn.components.Component;
import com.justy41.handdrawn.components.TransformComponent;

import java.util.HashMap;

public class Ecs {
    int nextEntity;
    public HashMap<Integer, TransformComponent> transforms;

    public Ecs() {
        nextEntity = -1;
        transforms = new HashMap<Integer, TransformComponent>();
    }

    public int createEntity() {
        nextEntity++;
        transforms.put(nextEntity, null);
        // ...
        return nextEntity;
    }

    public void destroyEntity(int entity) {
        transforms.put(entity, transforms.get(nextEntity));
        // ...
        nextEntity--;
    }

    public <T extends Component> void addComponent(int entity, HashMap<Integer, T> componentMap, T component) {
        component.key = entity;
        component.enabled = true;
        componentMap.put(entity, component);
    }

    public <T extends Component> void removeComponent(HashMap<Integer, T> componentMap, T component) {
        componentMap.remove(component.key);
    }


}
