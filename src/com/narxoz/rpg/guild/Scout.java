package com.narxoz.rpg.guild;

public class Scout extends GuildMember {

    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void reportRoute(String topic, String payload) {
        System.out.println("\n[SEND] " + getName() + " (Scout) reports -> [" + topic + "]");
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("  [RECV] " + getName() + " (Scout) heard on [" + topic + "] from " + from.getName() + ": " + payload);
    }
}