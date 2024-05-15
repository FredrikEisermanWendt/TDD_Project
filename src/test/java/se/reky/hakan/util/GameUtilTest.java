package se.reky.hakan.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameUtilTest {
    private static GameUtil gameUtil;
    
    @BeforeAll
    static void setup(){
        gameUtil = new GameUtil();
    }
    
    @Test
    void passingNullShouldResultInGamingExeption() {
        assertThrows(GameException.class, ()-> gameUtil.toLowerCaseButFirstLetterCapitalized(null), "passing null should result in GamingExeption");
    }
    
    
}