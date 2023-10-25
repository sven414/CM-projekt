package se.dsve.adventureawaits;

import se.dsve.Main;

public class Adventure {
    private Player player;
    private Monster monster;
    private String adventureIntroduction;

    public Adventure(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void setAdventureIntroduction(String introduction) {
        this.adventureIntroduction = introduction;
    }

    public void startAdventure(Player player, Monster monster) {
        String adventureIntroduction = "Du står framför en mörk och förunderlig grotta. Våta droppstenar hänger från taket och en isande vind drar genom grottan. Din fackla kastar långa skuggor över väggarna, men når inte så långt. Går du in? (Y/N)";
        String adveentureDescription = "Du går försiktigt in i grottan. Stannar och lyssnar... Är det andetag du hör. Hjärtat klappar. Men du fortsätter. Plötsligt ser du en hög svart skugga framför dig. Där står " + monster.getName() + "!";
        if (adventureIntroduction != null) {
            String choice = Main.readPrompt(adventureIntroduction);
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println(adveentureDescription);
                boolean adventureFinished = player.attack(player, monster);
                if (adventureFinished) {
                    System.out.println("Äventyret är över och du har funnit en skatt med 100 guld!\n\n");
                    player.addGold(100);
                }
            } else {
                System.out.println("Du valde att inte gå in. Tillbaka till huvudmenyn.");
            }
        } else {
            System.out.println("Ingen introduktion till äventyret angiven.");
        }
    }

    private void enterAdventure() {
        // Implementera själva äventyret här, t.ex., möte med monster eller hitta skatt.
    }
}
