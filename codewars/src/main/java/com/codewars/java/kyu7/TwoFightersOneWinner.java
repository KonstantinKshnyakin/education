package com.codewars.java.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function that returns the name of the winner in a fight between two fighters.
 * <p>
 * Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
 * <p>
 * Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
 * <p>
 * Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.
 * <p>
 * Your function also receives a third argument, a string, with the name of the fighter that attacks first.
 */
public class TwoFightersOneWinner {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        boolean isFirst = fighter1.name.equals(firstAttacker);
        Fighter first = isFirst ? fighter1 : fighter2;
        Fighter second = isFirst ? fighter2 : fighter1;
        while (true) {
            if ((second.health -= first.damagePerAttack) <= 0){
                return first.name;
            }
            if ((first.health -= second.damagePerAttack) <= 0){
                return second.name;
            }
        }
    }

    @Test
    public void basicTests() {
        assertEquals("Lew", declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    public static class Fighter {

        public String name;
        public int health;
        public int damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }

}
