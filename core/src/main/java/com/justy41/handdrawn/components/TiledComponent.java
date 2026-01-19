package com.justy41.handdrawn.components;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class TiledComponent extends Component{
    public TiledMap map;

    public TiledComponent(String path) {
        map = new TmxMapLoader().load(path);
    }
}
