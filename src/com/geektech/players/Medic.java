package com.geektech.players;

public class Medic extends Hero{

    private int healPoints;

    public Medic(int health, int damage, String name,
                 EnumSuperAbility superAbility, int healPoints) {
        super(health, damage, name, superAbility);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0 &&
                    avengers[i] != this){
                avengers[i].setHealth(avengers[i].getHealth() + healPoints);
            }
        }
        System.out.println(this.getName() + " to heal " + healPoints);
    }
}
