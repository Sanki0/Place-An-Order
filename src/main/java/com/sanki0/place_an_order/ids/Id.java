package com.sanki0.place_an_order.ids;

import java.util.UUID;

public abstract class Id {

    public UUID generateId(){
        return UUID.randomUUID();
    }
}
