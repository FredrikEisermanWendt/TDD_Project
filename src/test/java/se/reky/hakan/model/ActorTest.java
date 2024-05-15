package se.reky.hakan.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {
    Player player = new Player("Kalle", 10, 10);
    Goblin goblin = new Goblin("Goblin", 20, 20 );
    
    
    @Test
    void attack() {
        player.attack(goblin);
        assertEquals(10, goblin.getHp());
    }
    
    
    
}