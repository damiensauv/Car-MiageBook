package Util;

import Domain.Interface.IUser;

public abstract class Visitor<T> {

    public void visiter(IDomainObject o) {
        o.accept(this);
    }

    abstract public void visiter(IUser o);
}