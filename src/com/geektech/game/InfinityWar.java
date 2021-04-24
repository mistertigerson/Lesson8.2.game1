package com.geektech.game;

import com.geektech.players.*;

public class InfinityWar {

    public static void startBattle() {
        Boss thanos = new Boss(10000, 50,
                "\uD83D\uDFE3 Thanos");
        thanos.setDamage(50);

        CaptainAmerica captainAmerica = new CaptainAmerica(
                250, 25, "\uD83D\uDEE1 Captain America️",
                EnumSuperAbility.SHIELD_STRIKE);
        captainAmerica.setDamage(25);

        IronMan ironMan = new IronMan(
                220, 30, "\uD83E\uDDBE\uD83E\uDD16 Iron Man",
                EnumSuperAbility.SUPER_SHOOT);
        ironMan.setDamage(30);
        Hulk hulk = new Hulk(
                300, 35, "\uD83D\uDFE2 Hulk  ",
                EnumSuperAbility.ALL_CRASH);
        hulk.setDamage(5);
        Medic doc = new Medic(
                220, 5, "\uD83D\uDC8A️ Doctor",
                EnumSuperAbility.TO_HEAL, 15);
        doc.setDamage(5);

        Medic assistant = new Medic(
                240, 5, "\uD83D\uDC89 Assistant",
                EnumSuperAbility.TO_HEAL, 10);
        assistant.setDamage(5);

        Thor thor = new Thor(256, 23, "\uD83C\uDF29️ Thor",
                EnumSuperAbility.STAN);
        thor.setDamage(23);

        Tank tank = new Tank(600, 5, "Tank",
                EnumSuperAbility.RELAX);
        tank.setDamage(5);

        Wither wither = new Wither(245, 0, "Wither",
                EnumSuperAbility.WRATH);
        wither.setDamage(0);

        Hero[] avengers = {captainAmerica, ironMan,
                hulk, doc, assistant, thor, tank, wither};


        System.out.println("_____THE INFINITY WAR IS STARTED_____");
        printStatistics(thanos, avengers);

        while (!isGameFinished(thanos, avengers)) {
            round(thanos, avengers);
        }
    }

    private static void round(Boss thanos, Hero[] avengers) {
        bossDamage(thanos, avengers);
        avengersDamage(thanos, avengers);
        applySuperAbility(thanos, avengers);
        printStatistics(thanos, avengers);
    }

    private static boolean isGameFinished(Boss boss, Hero[] avengers) {
        if (boss.getHealth() <= 0) {
            System.out.println("Avengers won!!!");
            return true;
        }

        boolean allAvengersDead = true;
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0) {
                allAvengersDead = false;
                break;
            }
        }
        if (allAvengersDead) {
            System.out.println("Thanos Won!!!");
        }
        return allAvengersDead;
    }

    private static void avengersDamage(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - avengers[i].getDamage());
            }
        }
    }

    private static void applySuperAbility(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0) {
                avengers[i].applySuperAbility(boss, avengers);
            }
        }
    }


    private static void bossDamage(Boss boss, Hero[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0) {
                avengers[i].setHealth(avengers[i].getHealth() - boss.getDamage());
            }
        }
    }

    public static void printStatistics(Boss boss, Hero[] avengers) {
        System.out.println(boss.getName() + " : " +
                boss.getHealth() + " damage " +
                boss.getDamage());
        for (int i = 0; i < avengers.length; i++) {
            System.out.println(avengers[i].getName() + " : " +
                    avengers[i].getHealth() + " damage " +
                    avengers[i].getDamage());
        }
        System.out.println("_________________");
    }
}
