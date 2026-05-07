package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.List;

public class CouncilEngine {

    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {
        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 0;

        Captain speaker = new Captain("Council Speaker", hall);

        System.out.println("\n--- [ Phase 1: Reviewing Quests (Reverse Order) ] ---");
        QuestIterator reverseIt = questLog.reverse();
        while (reverseIt.hasNext()) {
            Quest q = reverseIt.next();
            System.out.println("\nReviewing: " + q.getTitle());
            questsTraversed++;

            speaker.issueOrder("supplies", q.getTitle() + " (Gold: " + q.getRewardGold() + ")");
            messagesRouted++;
            membersNotified++;
        }

        System.out.println("\n--- [ Phase 2: Prioritizing Urgent Threats (Priority Filter) ] ---");
        QuestIterator priorityIt = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (priorityIt.hasNext()) {
            Quest q = priorityIt.next();
            System.out.println("\nURGENT PLANNING: " + q.getTitle());
            questsTraversed++;

            speaker.issueOrder("healing", q.getTitle());
            messagesRouted++;
            membersNotified++;

            speaker.issueOrder("scouting", q.getTitle());
            messagesRouted++;
            membersNotified++;

            speaker.issueOrder("curses", q.getTitle());
            messagesRouted++;
            membersNotified++;
        }

        return new CouncilRunResult(questsTraversed, messagesRouted, membersNotified);
    }
}