package com.justy41.handdrawn.components;

import com.badlogic.gdx.math.Vector2;

public class RigidBody extends Component {
    Vector2 velocity;
    float gravity;

    RigidBody() {
        velocity = new Vector2(0, 0);
        gravity = 1;
    }

    RigidBody(float velX, float velY, float gravity) {
        velocity = new Vector2(velX, velY);
        this.gravity = gravity;
    }
}
