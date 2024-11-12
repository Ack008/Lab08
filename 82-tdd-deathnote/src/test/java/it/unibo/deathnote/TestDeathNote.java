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
    DeathNote deathNote;
    @BeforeEach
    void setup(){
        deathNote = new DeathNoteImplementation();
    }



    @Test
    void test1(){
        try{
            deathNote.getRule(0);
        }catch(IllegalArgumentException e){
            final String msg =e.getCause().getMessage();
            assertNotNull(msg);
            assertNotEquals(msg, "");
        }

        try{
            deathNote.getRule(-100);
        }catch(IllegalArgumentException e){
            final String msg =e.getCause().getMessage();
            assertNotNull(msg);
            assertNotEquals(msg, "");
        }
    }
}