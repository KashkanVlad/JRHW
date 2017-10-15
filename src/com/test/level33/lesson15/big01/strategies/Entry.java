package com.test.level33.lesson15.big01.strategies;

import java.io.Serializable;


public class Entry<key, value> implements Serializable {

    final Long key;
    String value;
    Entry<key, value> next;
    final int hash;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public Long getKey()
    {
        return this.key;
    }
    public String getValue()
    {
        return this.value;
    }
    public int hashCode()
    {
        return getKey().hashCode() ^ getValue().hashCode() ;
    }
    public String toString()
    {
        return getKey() + "=" + getValue();
    }
}