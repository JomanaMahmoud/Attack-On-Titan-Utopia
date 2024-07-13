# Attack On Titan: Utopia

## Preview

### Screenshots

![Start Page](https://github.com/user-attachments/assets/d97bb126-2a33-44f7-a787-1f6ada9bbe43)
![Video Scene](https://github.com/user-attachments/assets/9b627df8-85e3-4f4f-ab55-ac9940024452)
![Easy Mode](https://github.com/user-attachments/assets/90a7274b-3e78-4542-9c7e-4a8f6a199175)
![Hard Mode](https://github.com/user-attachments/assets/590f7b41-acbd-458b-9130-a03727361bcd)

### Gameplay Video

*Embed a gameplay video or provide a link to a video showcasing the game.*

## Project Description
**Attack On Titan: Utopia** is a one-player, endless tower defense game inspired by the hit anime *Attack on Titan*. The game is set in the Utopia District of Wall Rose, where players must defend against waves of titans using a variety of Anti-Titan weapons. The objective is to prevent the titans from breaching the walls of Utopia for as long as possible.

## Table of Contents
- [Installation](#installation)
  - [IntelliJ IDEA](#intellij-idea)
  - [Eclipse](#eclipse)
- [Dependencies](#dependencies)
- [Gameplay](#gameplay)
  - [Game Elements](#game-elements)
- [Preview](#preview)
- [Credits](#credits)

## Installation

### IntelliJ IDEA
To get started with **Attack On Titan: Utopia** in IntelliJ IDEA, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yehiarasheed/Attack-On-Titan-Utopia.git
    cd Attack-On-Titan-Utopia
    ```

2. **Open the project in IntelliJ IDEA**:
    - Go to `File` > `Open...` and select the project directory.
    - Ensure the correct JDK is set up for the project (JDK 11 or higher).

3. **Set up JavaFX**:
    - Download the JavaFX SDK from the [Gluon JavaFX download page](https://gluonhq.com/products/javafx/).
    - Extract the JavaFX SDK to a directory on your computer.
    - Go to `File` > `Project Structure...` > `Libraries` and add the JavaFX `lib` directory.
    - Go to `Run` > `Edit Configurations...` and add VM options to include the JavaFX libraries:

       ```plaintext
      --module-path /path_to_javafx_lib --add-modules javafx.controls,javafx.fxml,javafx.media
      ```

4. **Build and run the project**:
    - Build the project by going to `Build` > `Build Project`.
    - Run the project by selecting the main class and clicking the run button.

### Eclipse
To get started with **Attack On Titan: Utopia** in Eclipse, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yehiarasheed/Attack-On-Titan-Utopia.git
    cd Attack-On-Titan-Utopia
    ```

2. **Open the project in Eclipse**:
    - Go to `File` > `Import...` > `Existing Projects into Workspace`.
    - Select the cloned repository directory.

3. **Set up JavaFX**:
    - Download the JavaFX SDK from the [Gluon JavaFX download page](https://gluonhq.com/products/javafx/).
    - Extract the JavaFX SDK to a directory on your computer.
    - Go to `Project` > `Properties` > `Java Build Path` > `Libraries` > `Modulepath` > `Add External JARs...` and add all the JAR files from the JavaFX `lib` directory.
    - Go to `Run` > `Run Configurations...` and add VM options to include the JavaFX libraries:

      ```plaintext
      --module-path /path_to_javafx_lib --add-modules javafx.controls,javafx.fxml,javafx.media
      ```

4. **Build and run the project**:
    - Right-click on the project and select `Build Project`.
    - Run the project by selecting the main class and clicking the run button.

## Dependencies
- **JavaFX**: Required for the user interface. [JavaFX SDK Download](https://gluonhq.com/products/javafx/)
- **JDK 11 or higher**

For more information on setting up JavaFX, refer to the [Bro Code JavaFX Playlist](https://www.youtube.com/watch?v=_7OM-cMYWbQ&list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev).

## Game Elements
- **Titans**: Enemies with various stats like HP, Damage, Speed, and special traits.
- **Weapons**: Defensive tools with different attack behaviors and costs.
- **Wall Parts**: Defensive structures with HP that need to be protected.
  
### Phases

The game progresses through different phases based on the number of turns elapsed:

- **Early Phase**: Starts with minimal titan spawns.
- **Intense Phase**: More challenging with increased titan spawns, including tougher types.
- **Grumbling Phase**: Most difficult phase with frequent spawns of the largest titans.

### Titans

#### Types of Titans

| Type          | HP   | Damage | Height | Speed | Resources Value | Danger Level | Special Trait               |
|---------------|------|--------|--------|-------|-----------------|--------------|-----------------------------|
| Pure Titan    | 100  | 15     | 15     | 10    | 10              | 1            | -                           |
| Abnormal Titan| 100  | 20     | 10     | 15    | 15              | 2            | Attacks twice per turn      |
| Armored Titan | 200  | 85     | 15     | 10    | 30              | 3            | Takes only 25% damage       |
| Colossal Titan| 1000 | 100    | 60     | 5     | 60              | 4            | Increases speed each move   |

### Weapons

#### Types of Weapons

| Weapon Type       | Price | Damage | Attack Action                           |
|-------------------|-------|--------|-----------------------------------------|
| Piercing Cannon   | 25    | 10     | Attacks closest 5 titans to the wall     |
| Sniper Cannon     | 25    | 35     | Attacks the first closest titan to wall  |
| Volley Spread Cannon | 100 | 5      | Attacks all titans between min and max range |
| Wall Spread Cannon| 20    | 50     | Attacks all titans in the lane           |
| Wall Trap         | 75    | 100    | Attacks a titan that reached the walls   |
| Proximity Trap    | -     | -      | Attacks titans near the trap location    |

### Game Rules

- **Winning and Losing Conditions**: The game has no winning condition; players aim to survive as long as possible. Losing occurs when all wall parts are destroyed.
- **Titan Movement**: Titans move closer to the wall each turn based on their speed.
- **Attack Actions**: Titans and weapons perform attack actions each turn, affecting wall parts and titans respectively.
- **Defeated Targets**: Defeated titans add resources and score to the player. Destroyed wall parts render lanes inactive.

### Turn Actions

Each turn, players can choose to deploy weapons or pass. Turn sequence involves titan movement, weapon attacks, new titan spawns, and phase updates.

This structure provides a detailed breakdown of the game's mechanics, making it easier for users to understand the gameplay elements and strategies involved in **Attack On Titan: Utopia**. Adjust the content as per your specific game details and preferences.

## Credits
- **Developers**: Yehia Rasheed...
- **Inspired by**: *Attack on Titan* anime series
---
