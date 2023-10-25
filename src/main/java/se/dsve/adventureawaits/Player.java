package se.dsve.adventureawaits;

import java.util.HashMap;

/*
 * ----------------------------------------------------------------------------
 * Copyright (c) 2019-2023 Marcus Medina, DSVE AB.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * ----------------------------------------------------------------------------
 */

public class Player {
    private String name = "";

    private int hp;
    private int level;
    private int xp;
    private Weapon weapon;
    private int goldAmount;
    private HashMap<String, Integer> monsterEncounters = new HashMap<String, Integer>();

    public Player() {
        this.name = "";                         //placehoder där spelarens namn ska läggas
        this.hp = 100;                          //hälsa börjar på 100 %
        this.level = 1;                         //level börjar på 1
        this.xp = 0;                            //erfarenhet börjar på 0
        this.weapon = new Weapon();             //skaffa ett första vapen
        //inledande vapenstyrka
        this.goldAmount = 0;                    //inledande mängd guld
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int newXp) {
        this.xp += newXp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void addGold(int newGold) {
        this.goldAmount += newGold;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean attack(Player player, Monster monster) {
        String whoAttacks;
        double randomValue = Math.random();
        if (randomValue < 0.8) {
            whoAttacks = "player";
            System.out.println("Du anfaller med din " + getWeapon().getName() +".");
            int injury = this.calculateDamage(monster.getDamage());
            monster.applyDamage(injury);                             //minskar monstrets HP med injury.
        } else {
            whoAttacks = "monster";
            System.out.println(monster.getName() + " anfaller dig.");
            int injury = this.calculateDamage(this.getHp());
            int newHealth = this.getHp() - injury;
            this.setHp(newHealth);
        }
        boolean inBattle = true;
        while (inBattle) {
            if (monster.isDead()) {
                System.out.print("Du har besegrat " + monster.getName());
                System.out.println(" och tjänat 20 XP!");
                this.addXp(50);
                inBattle = false;
                break;
            } else if (!player.isAlive()) {
                System.out.println("Du är död. Spelet är över.\n Välkommen tillbaka en annan gång!");
                inBattle = false;
                break;
            } else {
                inBattle = true;
            }
            if (whoAttacks.equals("player")) {
                int damage = player.getWeapon().getDamage();
                int damageDealt = calculateDamage(damage);
                monster.applyDamage(damageDealt);                 // Applicera skadan på monstret
                whoAttacks = "monster";
                break;
            } else if (whoAttacks.equals("monster")) {
                int damage = monster.getDamage();
                int damageDealt = calculateDamage(damage);
                int newHealth = player.getHp();
                newHealth -= damageDealt;
                player.setHp(newHealth);
                whoAttacks = "player";
                break;
            }
        }
        return true;
    }

    private int calculateDamage(int damage) {

        double randomValue = Math.random();
        if (randomValue < 0.9) {
            double newDamage = randomValue * damage * 0.10;
            int NewDamageInt = (int) newDamage;
            return NewDamageInt;
        } else {
            double newDamage = damage * 0.10;
            int NewDamageInt = (int) newDamage;
            return NewDamageInt;
        }
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void levelUp(GameEngine gameEngine) {
        // Skriv din kod här
        // Tips: Använd gameEngine.levelXp för att kolla om spelaren ska levla upp
    }

}



