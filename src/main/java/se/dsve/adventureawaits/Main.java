package se.dsve;

/*
 * ----------------------------------------------------------------------------
 * Copyright (c) 2019-2023 Marcus Medina, DSVE AB.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 * ----------------------------------------------------------------------------
 */
import se.dsve.adventureawaits.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Startar");
        Player player = new Player();
        Menu menu = new Menu(player);
        Shop shop = new Shop();
        Weapon weapon = new Weapon();
        GameEngine gameEngine = new GameEngine(player, menu);
        gameEngine.startGame(player, menu, shop, weapon);       //startat spelet
    }
    public static String readPrompt(String question) {         // global metod för att läsa in från prompten
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
