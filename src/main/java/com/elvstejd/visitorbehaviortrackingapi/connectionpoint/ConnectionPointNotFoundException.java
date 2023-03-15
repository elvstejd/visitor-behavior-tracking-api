package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

public class ConnectionPointNotFoundException extends RuntimeException{
    public ConnectionPointNotFoundException(Long id) {
        super("Connection point with id " + id + " does not exist.");
    }
}
