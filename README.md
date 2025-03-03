# Okey Game - Java Implementation

## Overview

This project is a Java-based simulation of the popular Turkish game **Okey**. It includes core functionalities such as:

- Initializing and shuffling 106 Okey tiles
- Selecting an **indicator tile** and calculating the **okey tile**
- Distributing tiles to four players
- Evaluating hands to determine the best possible set of tile arrangements
- Considering **sahte okey** (fake okey) and **okey** tile logic in hand evaluations

## Features

- **Tile Management**: Handles tile creation, shuffling, and distribution.
- **Hand Evaluation**: Detects valid sequences (series) and pairs.
- **Okey & Fake Okey Usage**: Correctly substitutes tiles to form valid combinations.
- **Best Hand Detection**: Determines the closest hand to completion.

## Installation & Usage

### Prerequisites

- Java 17 or later

### Running the Game

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/okey-game-java.git
   ```
2. Navigate to the project directory:
   ```sh
   cd okey-game-java
   ```
3. Compile and run the game:
   ```sh
   javac OkeyGame.java
   java OkeyGame
   ```

## Code Structure

```
OkeyGame.java    # Main game logic
Tile.java        # Represents an Okey tile
Player.java      # Manages player hands and evaluation
```

## Game Rules Implemented

- Each player receives **14 tiles**, except for one player who starts with **15**.
- The **indicator tile** determines the **okey tile** (indicator +1).
- **Pairs and sequences** are detected for each hand.
- The player with the best hand (minimum missing tiles) is determined.

## Example Output

```
Gösterge: Siyah-4 | Okey Taşı: Siyah-5 | Sahte Okey: Siyah-5
Oyuncu 1'in eli: [Sarı-3, Mavi-7, Siyah-10, ...]
En iyi el Oyuncu 3'de!
```

