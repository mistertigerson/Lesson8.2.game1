package com.geektech.players;

import java.util.Random;

public class IronMan extends Hero{
    Random random = new Random();

    public IronMan(int health, int damage, String name,
                   EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        int count = 0;
        while (count<=avengers.length){
            for (int i = 0; i < avengers.length; i++) {
                avengers[i].setDamage();
                if (avengers[i].getHealth() > 0 && avengers[i] != this) {
                    avengers[i].setDamage(avengers[i].getDamage() + random.nextInt(60));
                    count++;
                }
        }

        }

    }
}
