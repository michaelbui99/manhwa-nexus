package io.github.michaelbui99.manhwanexus.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {
    /**
     * Util method for converting list into HashMap.
     * Can be used to prevent iterating a list multiple times when trying to check if the list contains a specific value
     */
    public static <TKey, TVal> Map<TKey, TVal> fromList(List<TKey> list, TVal fillVal) {
        Map<TKey, TVal> map = new HashMap<>();
        list.forEach(item -> map.put(item, fillVal));

        return map;
    }
}
