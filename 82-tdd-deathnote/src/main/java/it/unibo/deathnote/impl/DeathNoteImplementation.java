package it.unibo.deathnote.impl;
import java.util.HashMap;
import java.util.Map;

import it.unibo.deathnote.api.*;

public class DeathNoteImplementation implements DeathNote{
    final static private long millisecondsWhithinCanSpecifyCause = 40;
    final static private long millisecondsWhithinCanSpecifyDetails = 6 * 1000 + 40;
    private class DeathInfo{
        public final static String defaultDeathCause = "heart attack";
        private String deathCause;
        private String deathDetails;
        public DeathInfo(){
            this(defaultDeathCause, "");
        }
        public DeathInfo(final String cause, final String deteils){
            deathCause = cause;
            deathDetails = deteils;
        }
        public String getDeathCause(){
            return deathCause;
        }

        public String getDeathDetails(){
            return deathDetails;
        }

        public void setCause(final String cause){
            deathCause = cause;
        }
        
        public void setDetails(final String details){
            deathDetails = details;
        }
        
    }

    final private Map<String,DeathInfo> writtenName;
    private String nameOnWhichICanWorkWith;
    private long timeOfLastWriting;
    public DeathNoteImplementation(){
        writtenName = new HashMap<>();
    }

    @Override
    public String getDeathCause(final String name) {
        if(!writtenName.containsKey(name)){
            throw new IllegalArgumentException("Name not written yet");
        }
        return writtenName.get(name).getDeathCause();
    }

    @Override
    public String getDeathDetails(final String name) {
        if(!writtenName.containsKey(name)){
            throw new IllegalArgumentException("Name not written yet");
        }
        return writtenName.get(name).getDeathDetails();

    }

    @Override
    public String getRule(final int ruleNumber) {
        if(ruleNumber < 1){
            throw new IllegalArgumentException("rule number < 1");
        }
        if(ruleNumber >= DeathNote.RULES.size()){
            throw new IllegalArgumentException("rule number >= than the number of rules");
        }
        return DeathNote.RULES.get(ruleNumber - 1);
    }

    @Override
    public boolean isNameWritten(final String name) {
        return writtenName.containsKey(name);

    }

    @Override
    public boolean writeDeathCause(final String cause) {
        if(nameOnWhichICanWorkWith == null || nameOnWhichICanWorkWith.equals("")){
            throw new IllegalStateException("You haven't yet written a single name on this book");
        }
        final long waitedTime = System.currentTimeMillis() - timeOfLastWriting;
        if(waitedTime <= millisecondsWhithinCanSpecifyCause){
            writtenName.get(nameOnWhichICanWorkWith).setCause(cause);
            return true;
        }
        return false;

    }

    @Override
    public boolean writeDetails(final String details) {
        if(nameOnWhichICanWorkWith == null || nameOnWhichICanWorkWith.equals("")){
            throw new IllegalStateException("you haven't written a name yet");
        }

        final long waitedTime = System.currentTimeMillis() - timeOfLastWriting;
        if(waitedTime <= millisecondsWhithinCanSpecifyCause){
            writtenName.get(nameOnWhichICanWorkWith).setDetails(details);
            return true;
        }
        return false;

    }

    @Override
    public void writeName(final String name) {
        if(this.isNameWritten(name)){
            throw new IllegalArgumentException("Name already written");
        }
        writtenName.put(name, new DeathInfo());
        nameOnWhichICanWorkWith = name;
        timeOfLastWriting = System.currentTimeMillis();
    }
    
}