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

    GET_NICKNAME(APIType.GET, "getRandomNickname", "/minecraft/server/nicknames/random"),
    NICKNAME_BLACKLISTED(APIType.GET, "isNicknameBlacklisted", "/minecraft/server/nicknames/isBlacklisted/%s"),
    RESERVE_NICKNAME(APIType.POST, "reserveNickname", "/minecraft/server/nicknames/reserve"),
    FREE_NICKNAME(APIType.POST, "freeNickname", "/minecraft/server/nicknames/free"),

    GET_MESSAGES(APIType.GET, "getScheduledMessages", "/minecraft/server/messages"),
    GET_MESSAGE_BY_ID(APIType.GET, "getScheduledMessage", "/minecraft/server/messages/%s"),
    UPDATE_MESSAGE(APIType.POST, "updateScheduledMessage", "/minecraft/server/messages/update"),
    CREATE_MESSAGE(APIType.POST, "createScheduledMessage", "/minecraft/server/messages/create"),

    GET_ITEMS(APIType.GET, "getAllItemDescription", "/minecraft/server/items"),
    GET_ITEMS_BY_ID(APIType.GET, "getItemDescription", "/minecraft/server/items/%s"),
    UPDATE_ITEM(APIType.POST, "updateItemDescription", "/minecraft/server/items/update"),
    CREATE_ITEM(APIType.POST, "createItemDescription", "/minecraft/server/items/create"),

    GET_HOSTS(APIType.GET, "getAllHostRecord", "/minecraft/server/hosts"),
    GET_HOSTS_BY_ID(APIType.GET, "getHostRecord", "/minecraft/server/hosts/%s"),
    UPDATE_HOST(APIType.POST, "updateHostRecord", "/minecraft/server/hosts/update"),
    CREATE_HOST(APIType.POST, "createHostRecord", "/minecraft/server/hosts/create"),

    GET_GROUPS(APIType.GET, "getAllPlayerGroups", "/minecraft/server/groups"),
    GET_GROUPS_BY_ID(APIType.GET, "getPlayerGroup", "/minecraft/server/groups/%s"),
    UPDATE_GROUP(APIType.POST, "updatePlayerGroup", "/minecraft/server/groups/update"),
    CREATE_GROUP(APIType.POST, "createPlayerGroup", "/minecraft/server/groups/create"),

    GET_FRIENDSHIP_REQUEST_BY_UUID(APIType.GET, "getFriendshipDemandList", "/minecraft/server/friendship/requests/%s"),
    GET_FRIENDSHIP_BY_UUID(APIType.GET, "getFriendshipList", "/minecraft/server/friendship/%s"),
    POST_FRIENDSHIP_REQUEST(APIType.POST, "postFriendshipDemand", "/minecraft/server/friendship/post"),
    ACCEPT_FRIENDSHIP_REQUEST(APIType.POST, "acceptFriendshipDemand", "/minecraft/server/friendship/accept"),
    DENY_FRIENDSHIP_REQUEST(APIType.POST, "refuseFriendshipDemand", "/minecraft/server/friendship/deny"),

    GET_ACHIEVEMENTS_CATEGORIES(APIType.GET, "getAchievementCategories", "/minecraft/server/achievements/category"),
    GET_ACHIEVEMENTS_CATEGORY(APIType.GET, "getAchievementCategory", "/minecraft/server/achievements/category/%s"),
    GET_ACHIEVEMENTS(APIType.GET, "getAchievements", "/minecraft/server/achievements"),
    GET_ACHIEVEMENT(APIType.GET, "getAchievement", "/minecraft/server/achievements/%s"),
    GET_ACHIEVEMENTS_PROGRESSES(APIType.GET, "getAchievementProgresses", "/minecraft/server/achievements/progress"),
    GET_ACHIEVEMENTS_PROGRESS(APIType.GET, "getAchievementProgress", "/minecraft/server/achievements/progress/%s"),
    UPDATE_ACHIEVEMENTS_PROGRESS(APIType.POST, "updateAchievementProgress", "/minecraft/server/achievements/progress/update"),
    CREATE_ACHIEVEMENTS_PROGRESS(APIType.POST, "createAchievementProgress", "/minecraft/server/achievements/progress/create"),

    PAYLOAD(APIType.POST, "payload", "/server/payload"),
    GET_PERMISSIONS(APIType.POST, "getPermissionsByType", "/minecraft/server/permissions"),

    CONFIG(APIType.GET, "getConfig", "/minecraft/server/config"),
    UPDATE_CONFIG(APIType.POST, "updateConfig", "/minecraft/server/config/update"),

    GET_DENOUNCES(APIType.GET, "getDenounces", "/minecraft/server/denounces"),
    CREATE_DENOUNCE(APIType.POST, "denouncePlayer", "/minecraft/server/denounces/create"),
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
