package com.geektech.players;

public class Tank extends Hero {

    public Tank(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        int counter = avengers.length;
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0) {
                if (avengers[i] == this){
                    avengers[i].setHealth(avengers[i].getHealth() - ((counter-1) * 10));
                }
                if ( avengers[i] != this){
                    avengers[i].setHealth(avengers[i].getHealth() + 10);
                }

            }

        }
        System.out.println("tank поглотил 1/5 урона от босса ");
    }
}
