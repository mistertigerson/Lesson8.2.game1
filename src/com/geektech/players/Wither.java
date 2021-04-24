package com.geektech.players;

public class Wither extends Hero {

    public Wither(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() == 0 && avengers[i] != this) {
                avengers[i].setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println(this.getName() + " пожертвовал собой и отдал свою жизнь " + avengers[i].getName());
                break;
            }

        }
    }
}
