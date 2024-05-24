package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

public class v extends w {
    private final List<n<?>> j;

    public v(List<n<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.j = list;
    }
}
