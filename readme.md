# Russian Roulette Game

This is a simple Android game simulating the classic "Russian Roulette" game, where players have a 50% chance of facing a shot or being lucky enough to avoid it. The game uses Kotlin, Android SDK, and a minimalistic UI. It's designed to be simple and fun, with the option to reset the game after each round.

## Features

- **Randomized Gameplay**: The game randomly determines whether a shot is fired or the player survives.
- **Play Again Option**: After each round, the player can click a button to restart the game.
- **Edge-to-Edge Display**: The app supports edge-to-edge layout, providing a full-screen experience on devices with system bars (e.g., status bar, navigation bar).
- **Minimalistic UI**: Simple interface with a `TextView` showing the result and a `Button` to trigger gameplay.

## How to Play

1. **Start the Game**: When the app is launched, you will see a message prompting you to press the button to play.
2. **Press "Play"**: Click the "Play" button to simulate a round of Russian Roulette.
    - **If you're lucky**, the app will display "No bullet, you're lucky!"
    - **If you're not**, it will show "Shot! Game over."
3. **Restart the Game**: After the round ends, the button text changes to "Play Again." Click it to reset the game and play another round.

## Code Overview

### `MainActivity.kt`

- **UI Components**:
    - A `TextView` (`resultTextView`) to display the result of each round.
    - A `Button` (`playButton`) to trigger the gameplay logic.

- **Game Logic**:
    - The app uses `Random.nextBoolean()` to simulate a random shot with a 50% chance of success (a shot fired).
    - If the shot is fired, the message shows "Shot! Game over." If the player survives, the message says "No bullet, you're lucky!"

- **Edge-to-Edge Support**: The app implements the `enableEdgeToEdge()` method, which ensures that the layout uses the full screen, accounting for system UI elements like status and navigation bars.

### Key Methods

- `playGame()`:
    - Determines if the player survives or faces a shot by generating a random boolean value.
    - Updates the `TextView` with the result and changes the button text to "Play Again".

- `resetGame()`:
    - Resets the game state to its initial state, restoring the default message ("Press the button to play!") and button text ("Play").
