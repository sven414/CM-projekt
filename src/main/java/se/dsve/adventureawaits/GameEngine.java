package se.dsve.adventureawaits;

/*
 * ----------------------------------------------------------------------------
 * Copyright (c) 2019-2023 Marcus Medina, DSVE AB.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * ----------------------------------------------------------------------------
 */

public class GameEngine {
    private Menu menu;
    private Player player;
    private int startHp;
    private int levelXp;
    private int weaponDamage;
    private String gameState;
    private boolean gameStarted;


    public GameEngine(Player player, Menu menu) {
        this.menu = menu;
        this.player = player;
        this.startHp = player.getHp();
        this.levelXp = player.getXp();
        this.weaponDamage = player.getWeapon().getDamage();
        this.gameStarted = true;
    }

    // Getter for startHp

    public void setDifficulty(int difficulty) {

    }

    public void startGame(Player player, Menu menu, Shop shop, Weapon weapon) {
        this.player = player;
        menu.yourName(player);
        System.out.println("Hej " + player.getName() + "!");
        gameStarted = true;
        gameLoop(shop, weapon);
    }

    public void endGame() {
        // End the game
    }

    public void gameLoop(Shop shop, Weapon weapon) {
        while (gameStarted) {
            if (player.getLevel() >= 10 || !player.isAlive()) {             //så länge spelare lever och inte nått nivå tio
                setGameStarted(false);
                break;
            }
            String choice = menu.showMenu("mainMenu", player, shop, weapon);          // Anrop för att visa menyn
            setGameStarted(true);
            break;
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}

