package com.geektech.players;


public class Hulk extends Hero {

    public Hulk(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0 && avengers[i] == this) {
                int random = (2 + (int) (Math.random() * 3));
                avengers[i].setDamage(avengers[i].getDamage() * random);
                System.out.println(avengers[i].getName() + " критует и умножает свой урон на " + random);
            }

        }
    }
}
