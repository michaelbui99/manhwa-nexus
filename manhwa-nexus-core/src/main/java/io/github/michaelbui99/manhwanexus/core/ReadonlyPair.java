package io.github.michaelbui99.manhwanexus.core;

public class ReadonlyPair<TKey, TVal> {
    private TKey key;
    private TVal val;

    public ReadonlyPair(TKey key, TVal value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("must contain key and value");
        }

        this.key = key;
        this.val = value;
    }

    public TKey key() {
        return key;
    }

    public TVal value() {
        return val;
    }
}
