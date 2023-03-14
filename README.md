# Overview

I’m using Spring Boot to build a visitor behavior tracking REST API that enables physical locations such as shopping centers, museums, or airports to track the movements and actions of visitors. 

The system would use WI-FI and Bluetooth technologies to collect data on visitor behavior, such as their location, the duration of their stay, and their interactions with different areas or items. It would then analyze this data to provide insights into visitor behavior and help improve the visitor experience.

![imagen](https://user-images.githubusercontent.com/47759122/225049297-7ad48315-f892-4a87-af76-0f26ceaf9a91.png)

To map user movement, we can imagine a series of hexagonal tiles laid on top of the floor plan. Using a straightforward coordinate system based on the row and column of each tile, we can identify each tile with a unique ID and determine its specific location on the floor plan.

For instance, `R7T12` means: Row #7, Tile #12
and represents the tile in the seventh row from the top and the twelfth tile from the left. Again, `R7T12` is both an ID, and coordinates for that tile.

Every time the customer moves in this physical space, their device connects to many WI-FI and bluetooth hotspots which would log that connection to the API. Since we would know where those hotspots are located, we could aggregate all customer connections and chart their journey through said space. 

## ER Diagram

![imagen](https://user-images.githubusercontent.com/47759122/225050230-499728da-0266-4a17-b726-6c4caa30c852.png)
  
## Folder structure

```
com.group.name/
├── entity/
│   ├── Entity.java (model)
│   ├── EntityController.java
│   ├── EntityRepository.java
│   └── EntityDAO.java
├── duck/
│   ├── Duck.java (model)
│   ├── DuckController.java
│   ├── DuckRepository.java
│   └── DuckDAO.java
└── Application.java
```
Instead of grouping by layer (model, controller, service, dao), I’m choosing to group files by feature or entity. This makes it easier to navigate the codebase by keeping related code together.
