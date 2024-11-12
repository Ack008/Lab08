import it.unibo.deathnote.api.*;

public class DeathNoteImplementation implements DeathNote{

    @Override
    public String getDeathCause(String name) {
        throw new Exception();
        return null;
    }

    @Override
    public String getDeathDetails(String name) {
        throw new Exception();
        return null;
    }

    @Override
    public String getRule(int ruleNumber) {
        throw new Exception();
        return null;
    }

    @Override
    public boolean isNameWritten(String name) {
        throw new Exception();
        return false;
    }

    @Override
    public boolean writeDeathCause(String cause) {
        throw new Exception();
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        throw new Exception();
        return false;
    }

    @Override
    public void writeName(String name) {
        throw new Exception();
    }
    
}