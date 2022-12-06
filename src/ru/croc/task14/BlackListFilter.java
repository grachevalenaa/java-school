package ru.croc.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface BlackListFilter<E extends Iterable<T>, T> {

    default List<T> toFilterComment(E in, Predicate<T> predicate) {
        List<T> out = new ArrayList<>();
        in.forEach(elem -> {
            if (predicate.test(elem))
                out.add(elem);
        });
        return out;
    }

}
