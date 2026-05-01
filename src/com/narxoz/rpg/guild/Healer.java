package com.narxoz.rpg.guild;

public class Healer extends GuildMember {

    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void prepareAid(String topic, String payload) {
        System.out.println("\n[SEND] " + getName() + " (Healer) sends medical update -> [" + topic + "]");
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("  [RECV] " + getName() + " (Healer) heard on [" + topic + "] from " + from.getName() + ": " + payload);
    }
}