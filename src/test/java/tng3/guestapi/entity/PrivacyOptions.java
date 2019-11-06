package tng3.guestapi.entity;

import tng3.base.Entity;

import java.util.Objects;


public class PrivacyOptions implements Entity {

    public boolean allowEmail;
    public boolean allowSms;
    public boolean allowPush;



    public PrivacyOptions() {
        this(true, true, true);
    }



    public PrivacyOptions(boolean allowEmail, boolean allowSms, boolean allowPush){
        this.allowEmail = allowEmail;
        this.allowSms = allowSms;
        this.allowPush = allowPush;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivacyOptions that = (PrivacyOptions) o;
        return allowEmail == that.allowEmail &&
                allowSms == that.allowSms &&
                allowPush == that.allowPush;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowEmail, allowSms, allowPush);
    }

}



