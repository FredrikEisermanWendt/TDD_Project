package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;


class PlayerInteractionTest {
    
    private Player player;
    
    
    @BeforeEach
    void defaultPlayerSetup() {
        player = new Player();
    }
    
    
    @Test
    void testingPlayerSetupNameShouldBeKalle() {
        PlayerInteraction playerInteraction = createPlayerInteractionWithScannerData("Kalle");
        playerInteraction.setupPlayer(player);
        assertEquals("Kalle", player.getName());
    }
    
    
    @Test
    void updatePlayerHealth() {
        PlayerInteraction playerInteraction = createPlayerInteractionWithScannerData("Kalle");
        int expectedHealth = player.getHp() + 10;
        playerInteraction.updatePlayerHealth(player, 10);
        Assertions.assertEquals(expectedHealth, player.getHp());
    }
    
    
    // TODO: 2024-05-15 finish method
    private PlayerInteraction createPlayerInteractionWithScannerData(String dataForScanner) {
        Scanner scan = new Scanner(dataForScanner);
        IOHandler ioHandler = new IOHandler(scan);
        PlayerInteraction playerInteraction = new SimplePlayerInteraction(ioHandler);
        return playerInteraction;
    }
    
    
}