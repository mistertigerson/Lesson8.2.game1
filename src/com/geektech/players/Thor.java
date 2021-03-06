package com.geektech.players;

import java.util.Random;

public class Thor extends Hero {
    Random random = new Random();

    public Thor(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        int integer = random.nextInt(3);
        boolean isStunned = random.nextBoolean();
        int counter = 0;
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0 && avengers[i] != this && avengers[i].getHealth() > 0 && boss.getHealth() > 0) {
                switch (integer) {
                    case 1:
                        avengers[i].setHealth(avengers[i].getHealth() + boss.getDamage());
                        counter++;
                        break;
                    default:
                        boss.setDamage(50);
                        break;
                }
                if (counter==1){
                    System.out.println("@@@@@@@тор оглушил босса");
                }
            }
        }



    }
}
