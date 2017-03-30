package com.asuper.abocha.cs_go.Mapper;

/**
 * Created by abakarmagomedov on 30.03.17.
 */

public interface Mapper<FROM, TO> {
    TO mapTo(FROM from);
    FROM mapFrom(TO to);
}
