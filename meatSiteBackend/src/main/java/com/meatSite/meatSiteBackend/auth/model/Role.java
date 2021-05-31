package com.meatSite.meatSiteBackend.auth.model;

public enum Role {
    ROLE_GUEST("ROLE_GUEST"),
    ROLE_SHOP_WORKER("ROLE_SELLER"),
    ROLE_WAREHOUSE_WORKER("ROLE_SELLER"),
    ROLE_SELLER("ROLE_SELLER"),
    ROLE_ADMINISTRATOR("ROLE_ADMINISTRATOR");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
