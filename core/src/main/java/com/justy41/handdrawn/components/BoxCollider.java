package com.justy41.handdrawn.components;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class BoxCollider extends Component{
    public Rectangle rect;
    public HashMap<String, Boolean> touching;
    public boolean isTrigger;

    public BoxCollider() {
        rect = null;
        touching = new HashMap<>();
        touching.put("right", false);
        touching.put("left", false);
        touching.put("up", false);
        touching.put("down", false);
        isTrigger = false;
    }

    public BoxCollider(float x, float y, float width, float height) {
        rect = new Rectangle(x, y, width, height);
        touching = new HashMap<>();
        touching.put("right", false);
        touching.put("left", false);
        touching.put("up", false);
        touching.put("down", false);
        isTrigger = false;
    }

    public BoxCollider(float x, float y, float width, float height, boolean isTrigger) {
        rect = new Rectangle(x, y, width, height);
        touching = new HashMap<>();
        touching.put("right", false);
        touching.put("left", false);
        touching.put("up", false);
        touching.put("down", false);
        this.isTrigger = isTrigger;
    }
}
