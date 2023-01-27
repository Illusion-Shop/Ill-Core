package net.illusion.core.util;


public class Time {

    private long millSeconds;

    private final long Year = 31536000000l;

    private final long Month = 2628000000l;

    private final long Day = 86400000l;

    private final long Hours = 3600000l;

    private final long Minutes = 60000l;
    private final long Seconds = 1000l;

    public Time(long millSeconds) {
        this.millSeconds += millSeconds;
    }

    public Time(int years, int months, int days, int hours, int minutes, int seconds) {
        this.millSeconds += (years * this.Year);
        this.millSeconds += (months * this.Month);
        this.millSeconds += (days * this.Day);
        this.millSeconds += (hours * this.Hours);
        this.millSeconds += (minutes * this.Minutes);
        this.millSeconds += (seconds * this.Seconds);
    }

    public long addYear(long years) {
        this.millSeconds += (years * this.Year);
        return this.millSeconds;
    }

    public long addMonth(long months) {
        this.millSeconds += (months * this.Month);
        return this.millSeconds;
    }

    public long addDays(long days) {
        this.millSeconds += (days * this.Day);
        return this.millSeconds;
    }

    public long addHours(long hours) {
        this.millSeconds += (hours * this.Hours);
        return this.millSeconds;
    }


    public long addMinutes(long minutes) {
        this.millSeconds += (minutes * this.Minutes);
        return this.millSeconds;
    }

    public long addSeconds(long seconds) {
        this.millSeconds += (seconds * this.Seconds);
        return this.millSeconds;
    }


    public boolean minYear(long year) {
        long result = this.millSeconds -= (year * this.Year);
        if (result > 0) {
            this.millSeconds -= result;
            return true;
        }
        return false;
    }

    public boolean minMonth(long months) {
        long result = this.millSeconds -= (months * this.Month);
        if (result > 0) {
            this.millSeconds -= result;
            return true;
        }
        return false;
    }

    public boolean minDays(long days) {
        long result = this.millSeconds -= (days * this.Day);
        if (result > 0) {
            this.millSeconds -= result;
            return true;
        }
        return false;
    }

    public boolean minHours(long hours) {
        long result = this.millSeconds -= (hours * this.Hours);
        if (result > 0) {
            this.millSeconds = result;
            return true;
        }
        return false;
    }

    public boolean minMinutes(long minutes) {
        long result = this.millSeconds -= (minutes * this.Minutes);
        if (result > 0) {
            this.millSeconds = result;
            return true;
        }
        return false;
    }

    public boolean minSeconds(long seconds) {
        long result = this.millSeconds -= (seconds * this.Seconds);
        if (result > 0) {
            this.millSeconds = result;
            return true;
        }

        return false;
    }

    public long getYear() {
        return millSeconds / Year;
    }

    public long getMonth() {
        return (getMillSeconds() % this.Year) / this.Month;
    }

    public long getDay() {

        return (getMillSeconds() % this.Month) / this.Day;
    }

    public long getHours() {
        return ((getMillSeconds() % this.Day) / Hours) - 10;
    }

    public long getMinutes() {
        return (getMillSeconds() % this.Hours) / Minutes;
    }

    public long getSeconds() {
        return (getMillSeconds() % this.Minutes) / Seconds;
    }

    public long getMillSeconds() {
        return millSeconds;
    }
}
