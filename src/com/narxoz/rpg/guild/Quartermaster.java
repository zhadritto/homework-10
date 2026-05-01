package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void requestSupplies(String topic, String payload) {
        System.out.println("\n[SEND] " + getName() + " (Quartermaster) requests -> [" + topic + "]");
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("  [RECV] " + getName() + " (Quartermaster) heard on [" + topic + "] from " + from.getName() + ": " + payload);
    }
}