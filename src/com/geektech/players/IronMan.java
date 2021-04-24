package com.geektech.players;

import java.util.Random;

public class IronMan extends Hero {
    Random random = new Random();

    public IronMan(int health, int damage, String name,
                   EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {

        for (int i = 0; i < avengers.length; i++) {
            int integer = random.nextInt(60);
            if (avengers[i].getHealth() > 0 && avengers[i] != this) {
                if (avengers[i].getName().equals("Captain America")) {
                    avengers[i].setDamage(25);
                } else if (avengers[i].getName().equals("Hulk")) {
                    avengers[i].setDamage(35);
                } else if (avengers[i].getName().equals("Doctor")) {
                    avengers[i].setDamage(5);
                } else if (avengers[i].getName().equals("Assistant")) {
                    avengers[i].setDamage(5);
                }
                avengers[i].setDamage(avengers[i].getDamage() + integer);
                System.out.println("iron man увеличил атаку " + avengers[i].getName() +
                        " каждого героя на " + integer);

            }
        }
    }
}


