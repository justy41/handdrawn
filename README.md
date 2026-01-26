# handdrawn

A little experiment project I've worked for a bit to see how to implement Tiled Parallax Scrolling backgrounds in libgdx.  
The art is hand-drawn in [Krita](https://krita.org/en/) and [Tiled](https://www.mapeditor.org/) was used for level editing (specifically the image layers and the object layers).

## Structure

The [Libgdx framework](https://libgdx.com/) for rendering and textures and it already has a Tiled importer built-in.  
The code structure is as follows:  

### Core
- a simple ECS class:
  - holds a handle of the OrthographicCamera and a handle to the SceneManager;
  - hashmaps that need to be manually added with every new component you make;
  - functions that act on the hashmaps (createEntity, addComponent);
- a StartScene that inherits from Scene class:
  - start function;
  - update function;
  - render function;
  - every scene holds an ECS class instance, a SceneManager instance and an OrthogonalTiledMapRenderer instance;
- a simple SceneManager:
  - manages the scenes in an ArrayList.

### Components
- a base Component class:
  - has a handle for the hashmap key (the entity);
  - a boolean "enabled";
- TransformComponent;
- BoxCollider (Axis-Aligned-Bounding-Boxes -> AABB. Can be solid or just a trigger zone);
- RigidBody (velocity and gravity;
- SpriteRenderer;
- TiledComponent (holds a TiledMap);
- Player (data for the player character).

### Systems
- LoadSystems (handles importing the Object Layers from Tiled based on a "Type" custom property);
- UpdateSystem (handles physics and AABB collision resolutions);
- RenderSystems (handles texture drawing, debug drawing and Tiled Parallax Layer rendering);
- CameraSystems (handles cameraFollow function to follow a position);
- PlayerSystems (handles the player movement).

## Assets

The assets were drawn by me with the mouse, on my laptop. They are a simple sketch of a few hills using a simple collor pallete.  
The "red_pixel.png" assets is made for debug drawing of the colliders (since libgdx doesnt have a rectangle draw function).
The "tilemaps" and "tilesets" folders were made to better organise the tilemaps and tilesets loaded in Tiled.

The background was exported as individual layers and assembled in Tiled with Image Layers (one image/layer).  
The parallax value can be set for each Image Layer.

## Result
