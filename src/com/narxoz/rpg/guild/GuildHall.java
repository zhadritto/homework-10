package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> membersByTopic = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        addSubscriber("ALL", member);

        String role = member.getClass().getSimpleName();
        switch (role) {
            case "Captain": addSubscriber("COMMAND", member); break;
            case "Healer": addSubscriber("MEDICAL", member); break;
            case "Quartermaster": addSubscriber("SUPPLIES", member); break;
            case "Scout": addSubscriber("RECON", member); break;
            case "Loremaster": addSubscriber("LORE", member); break;
        }
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        List<GuildMember> subs = subscribersFor(topic);
        for (GuildMember member : subs) {
            if (member != from) {
                member.receive(topic, from, payload);
            }
        }
    }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}