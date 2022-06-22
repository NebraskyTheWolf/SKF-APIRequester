package com.skfstudios.apirequester.types;

import java.util.Objects;

public enum APIRoutes {
    HOME(APIType.GET, "home", "/"),

    GET_PLAYER_BY_UUID(APIType.GET, "getPlayerByUUID", "/minecraft/server/player/%s"),
    CREATE_PLAYER(APIType.POST, "createPlayer", "/minecraft/player/create"),
    UPDATE_PLAYER(APIType.POST, "updatePlayer", "/minecraft/player/update"),

    GET_PLAYER_SETTINGS_BY_UUID(APIType.GET, "getPlayerSettingsByUUID", "/minecraft/player/settings/%s"),
    CREATE_SETTINGS_PLAYER(APIType.POST, "createSettingsPlayer", "/minecraft/player/settings/create"),
    UPDATE_SETTINGS_PLAYER(APIType.POST, "updateSettingsPlayer", "/minecraft/player/settings/update"),

    GET_ACTIVE_PROMOTIONS(APIType.GET, "getAllActivePromotions", "/minecraft/server/promotions"),
    GET_PROMOTION_BY_ID(APIType.GET, "getPromotionByID", "/minecraft/server/promotions/%s"),
    CREATE_PROMOTION(APIType.POST, "createPromotions", "/minecraft/server/promotions/create"),
    UPDATE_PROMOTION(APIType.POST, "deletePromotions", "/minecraft/server/promotions/delete"),

    GET_TRANSACTIONS(APIType.GET, "getTransactions", "/minecraft/server/transactions/%s/%s"),
    GET_TRANSACTIONS_BY_GAME(APIType.GET, "getTransactionsByGame", "/minecraft/server/transactions/%s/%s/%s"),
    CREATE_TRANSACTIONS(APIType.POST, "createTransactions", "/minecraft/server/transactions/create"),
    UPDATE_TRANSACTIONS(APIType.POST, "updateTransactions", "/minecraft/server/transactions/update"),

    PAYLOAD(APIType.POST, "payload", "/server/payload"),

    CONFIG(APIType.GET, "config", "/minecraft/server/config")
    ;

    public final APIType type;
    public final String name;
    public final String route;

    APIRoutes(APIType type, String name, String route) {
        this.type = type;
        this.name = name;
        this.route = route;
    }

    public APIRoutes getRouteByFuncID(String id) {
        for (APIRoutes value : values())
            if (Objects.equals(value.name, id))
                return value;
        return null;
    }
}
