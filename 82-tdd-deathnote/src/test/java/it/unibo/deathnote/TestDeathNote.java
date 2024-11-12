package it.unibo.deathnote;
import org.junit.jupiter.api.Test;
import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class TestDeathNote {
    private DeathNote deathNote;
    final String name2 = "Mario Draghi";
    final String name1 = "Antonio Conte";


    /*A method that stops for a fixed amount of milliseconds 
     * @param milliseconds millisecondas where the programs sleeps 
     * 
    */
    private void sleep(long milliseconds){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
        }
    }

    @BeforeEach
    void setup(){
        deathNote = new DeathNoteImplementation();
    }



    @Test
    void test1(){
        try{
            deathNote.getRule(0);
        }catch(IllegalArgumentException e){
            assertNotNull(e);
            final String msg =e.getMessage();
            assertNotNull(msg);
            assertNotEquals(msg, "");
        }

        try{
            deathNote.getRule(-100);
        }catch(IllegalArgumentException e){
            final String msg =e.getMessage();
            assertNotNull(msg);
            assertNotEquals(msg, "");
        }
    }
    
    @Test
    void test2(){
        for (final var rule : DeathNote.RULES) {
            assertNotNull(rule);
            assertNotEquals(rule, "");
        }
    }

    @Test
    void test3(){
        assertFalse(deathNote.isNameWritten(name1));
        deathNote.writeName(name1);
        assertTrue(deathNote.isNameWritten(name1));
        assertFalse(deathNote.isNameWritten(name2));
        assertFalse(deathNote.isNameWritten(""));
    }

    @Test
    void test4(){
        final String causeOfDeath1 = "karting accident";
        final String defaultCauseOfDeath = "heart attack";
        try{
            deathNote.writeDeathCause("Cancer");
        }catch(IllegalStateException e){
        }

        deathNote.writeName(name1);
        assertEquals(deathNote.getDeathCause(name1).toLowerCase(), defaultCauseOfDeath.toLowerCase());
        deathNote.writeName(name2);
        assertTrue(deathNote.writeDeathCause(causeOfDeath1));
        assertEquals(deathNote.getDeathCause(name2).toLowerCase(), causeOfDeath1.toLowerCase());
        sleep(100);
        assertFalse(deathNote.writeDeathCause("Hit by a car"));
    }

    @Test
    void test5(){
        final String detail1 = "ran for too long";
        final String detail2 = "Neightbours hears everithing";
        try {
            deathNote.writeDetails(detail2);
        } catch (IllegalStateException e) {
        }

        deathNote.writeName(name1);
        assertTrue(deathNote.writeDetails(detail1));
        assertEquals(deathNote.getDeathDetails(name1), detail1);
        deathNote.writeName(name2);
        sleep(6100);
        assertFalse(deathNote.writeDetails(detail2));
    }
}

