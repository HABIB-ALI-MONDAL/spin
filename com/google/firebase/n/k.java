package com.google.firebase.n;

public interface k {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int j;

        private a(int i) {
            this.j = i;
        }

        public int d() {
            return this.j;
        }
    }

    a b(String str);
}
