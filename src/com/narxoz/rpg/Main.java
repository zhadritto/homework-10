package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===\n");

        List<Hero> party = List.of(
                new Hero("Arthur the Brave", 100, 25, 15),
                new Hero("Merlin the Wise", 70, 150, 10, 5, 500) // или расширенный конструктор
        );
        QuestLog questLog = new QuestLog();
        questLog.add(new Quest("Clear the Rat Cellar", QuestPriority.LOW, 50, false));
        questLog.add(new Quest("Escort the Merchant", QuestPriority.NORMAL, 150, false));
        questLog.add(new Quest("Slay the Dragon", QuestPriority.URGENT, 5000, true));
        questLog.add(new Quest("Find the Lost Ring", QuestPriority.NORMAL, 300, false));
        questLog.add(new Quest("Cleanse the Cursed Ruins", QuestPriority.HIGH, 1000, true));
        GuildHall hall = new GuildHall();
        new Quartermaster("Stash", hall);
        new Scout("Swift", hall);
        new Healer("Mercy", hall);
        new Captain("Vanguard Jax", hall);
        new Loremaster("Eldric", hall);
        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(party, questLog, hall);
        System.out.println("\n--- [ Final Summary ] ---");
        System.out.println(result.toString());
    }
}