package se.dsve.adventureawaits;

/*
 * ----------------------------------------------------------------------------
 * Copyright (c) 2019-2023 Marcus Medina, DSVE AB.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * ----------------------------------------------------------------------------
 */

import se.dsve.Main;

public class Menu {
    private Player player;

    public Menu(Player player) {
        this.player = player;
        String welcomeMessage = "Välkommen till Äventyret!\n\n" +
                "Du är en modig och äventyrlig person som har bestämt dig för att utforska en mystisk värld fylld med monster och skatter.\n" +
                "Du har hört att det finns en skatt gömd i en grotta i närheten. \n" +
                "Du har också hört att det finns en mystisk portal som kan ta dig till en annan värld. \n" +
                "Du har bestämt dig för att utforska båda.\n\n";
        System.out.println(welcomeMessage);

    }

    protected void yourName(Player player) {
        String name = Main.readPrompt("Säg mig, vad är ditt namn?");
        player.setName(name);
    }

    public static String showMenu(String menu, Player player, Shop shop, Weapon weapon) {
        switch (menu) {
            case "mainMenu":
                String choice = Main.readPrompt("[1] - Gå på äventyr\n[2] - Visa information om spelaren\n[8] - Besök butiken\n[9] - Avsluta spelet\n[0] - Ändra svårighetsgrad\n");
                switch (choice) {
                    case "1":
                        Monster currentMonster = new Monster("Sommarskuggan", 2, 20);
                        Adventure currentAdventure = new Adventure(player, currentMonster);
                        currentAdventure.startAdventure(player, currentMonster);
                        break;
                    case "2":
                        // Visa information om spelaren
                        break;
                    case "8":
                        menu = "shopMenu";
                        break;
                    case "0":
                        menu = "mainMenu";
                        break;
                    default:
                        menu = "mainMenu";
                        break;
                }

            case "shopMenu":
                String shopChoice = Main.readPrompt("Du har " + player.getGoldAmount() + " guld. Dina val är:\n\n[1] - Öka din vapenkraft.\n[2] - Återställ din hp.\n\n[0] - Tillbaka till huvudmenyn\n");
                switch (shopChoice) {
                    case "1":
                        // Uppgradera vapnet
                        shop.upgradeWeapon(player, weapon);
                        break;
                    case "2":
                        // Återställ hälsa
                        shop.restoreHp(player);
                        break;
                    case "0":
                        menu = "mainMenu";
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
        return menu;
    }


    public static void navigate(String menu, int choice, Player player) {
    }
}

