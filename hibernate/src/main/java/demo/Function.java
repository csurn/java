package demo;

import java.io.Serializable;

public interface Function<T> extends Serializable {
    void accept(T t);
}