package com.cssrc.mibopoly.utils;

import com.cssrc.mibopoly.model.api.DateTimeTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

public final class EntityUtils {

    private EntityUtils() {}

    public static final Gson gson = new GsonBuilder()
            .setLenient()
            .registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter())
            .create();

}
