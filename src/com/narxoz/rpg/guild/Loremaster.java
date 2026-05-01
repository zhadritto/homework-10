package com.narxoz.rpg.guild;
public class Loremaster extends GuildMember {

    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void shareLore(String topic, String payload) {
        System.out.println("\n[SEND] " + getName() + " (Loremaster) shares knowledge -> [" + topic + "]");
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("  [RECV] " + getName() + " (Loremaster) chronicles from [" + topic + "] by " + from.getName() + ": " + payload);
    }
}