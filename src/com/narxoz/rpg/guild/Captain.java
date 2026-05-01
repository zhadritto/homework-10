package com.narxoz.rpg.guild;

public class Captain extends GuildMember {

    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void issueOrder(String topic, String payload) {
        System.out.println("\n[SEND] " + getName() + " (Captain) issues order -> [" + topic + "]");
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("  [RECV] " + getName() + " (Captain) heard on [" + topic + "] from " + from.getName() + ": " + payload);
    }
}