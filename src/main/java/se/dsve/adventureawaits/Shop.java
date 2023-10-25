package se.dsve.adventureawaits;

/*
 * ----------------------------------------------------------------------------
 * Copyright (c) 2019-2023 Marcus Medina, DSVE AB.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * ----------------------------------------------------------------------------
 */

import se.dsve.Main;

public class Shop {
    private int weaponUpgradeCost;
    private int hpRestoreCost;
    private int healthPrice = 2;

    public Shop() {
        this.weaponUpgradeCost = 10;
        this.healthPrice = 2;
    }

    //Metod för att återställa spelarens hälsa
    public void restoreHp(Player player) {
        System.out.println("Du har valt att uppgradera din hälsa. Mycket bra val!");
        int injury = 100 - player.getHp();                                                  // 100 är maxHealth
        hpRestoreCost = injury * healthPrice;                                                    // healthPrice är priset för återställd justeras efterhand
        if (player.getGoldAmount() >= hpRestoreCost) {                                         // Om man har tillräckligt med guld för att nå maxhälsa
            player.addGold(player.getGoldAmount() - hpRestoreCost);                        // Betalning via setter i Player-klassen
            player.setHp(100);                                                              // Maxar upp hälsan via setter o Player-klassen
            System.out.println("Din hälsa har återställt till 100% .");
        } else if (player.getGoldAmount() < hpRestoreCost && player.getGoldAmount() != 0) {      // Om man inte har guld för maxhälsa
            int affordableHealth = player.getGoldAmount() / healthPrice;                         // Räknar ut hur mycket hälsa man kan få för pengarna
            player.addGold(0);                                                             // Betalning är allt guld man har
            player.setHp(player.getHp() + affordableHealth);                           // Uppdatera hälsan till befintlig hälsa + så mycket hälsa man har råd med
            System.out.println("Din hälsa har återställts till " + player.getHp() + "%. Det är så mycket du hade råd med.");
        } else {
            System.out.println("Du har inget guld att köpa hälsa för.");
        }
    }
    public void upgradeWeapon(Player player, Weapon weapon) {
        int gold = player.getGoldAmount();
        if (weaponUpgradeCost <= gold) {
            System.out.println("Ditt vapen är på nivå " + weapon.getDamage() + ".");
            System.out.println("Du har " + gold + " guld att handla för.");
            System.out.println("Att uppgradera vapnet en nivå kostar " + weaponUpgradeCost + " guld.");
            String choise = Main.readPrompt("Vill du uppgradera vapnet en nivå? (Y/N)");
            if (choise == "Y") {
                player.getWeapon().setDamage(+10);
                System.out.println("Ditt vapen har nu uppdaterats.");
            }
        } else {
            System.out.println("Du har inte tillräckligt med guld för att uppgradera ditt vapen.");
        }
    }
}

