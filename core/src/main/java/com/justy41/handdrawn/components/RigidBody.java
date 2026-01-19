package com.justy41.handdrawn.components;

import com.badlogic.gdx.math.Vector2;

public class RigidBody extends Component {
    public Vector2 velocity;
    public float gravity;

    public RigidBody() {
        velocity = new Vector2(0, 0);
        gravity = 0;
    }

    public RigidBody(float velX, float velY, float gravity) {
        velocity = new Vector2(velX, velY);
        this.gravity = gravity;
    }
}
