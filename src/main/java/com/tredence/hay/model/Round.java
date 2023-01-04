package com.tredence.hay.model;

import java.math.BigInteger;
import java.util.Date;

public class Round {

    BigInteger Round_id;
    String Round_Name,panelist_id,organizer_id,profile_id,mode,isRescheduled,duration,round_type;
    Date scheduled_on,last_updated;

    public Round() {
    }

    public BigInteger getRound_id() {
        return Round_id;
    }

    public void setRound_id(BigInteger round_id) {
        Round_id = round_id;
    }

    public String getRound_Name() {
        return Round_Name;
    }

    public void setRound_Name(String round_Name) {
        Round_Name = round_Name;
    }

    public String getPanelist_id() {
        return panelist_id;
    }

    public void setPanelist_id(String panelist_id) {
        this.panelist_id = panelist_id;
    }

    public String getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(String organizer_id) {
        this.organizer_id = organizer_id;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIsRescheduled() {
        return isRescheduled;
    }

    public void setIsRescheduled(String isRescheduled) {
        this.isRescheduled = isRescheduled;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRound_type() {
        return round_type;
    }

    public void setRound_type(String round_type) {
        this.round_type = round_type;
    }

    public Date getScheduled_on() {
        return scheduled_on;
    }

    public void setScheduled_on(Date scheduled_on) {
        this.scheduled_on = scheduled_on;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }
}
