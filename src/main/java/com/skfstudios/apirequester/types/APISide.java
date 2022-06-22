package com.skfstudios.apirequester.types;

public enum APISide {
    SERVER("server"),
    CLIENT("client");

    private String side;

    APISide(String side) {
        this.side = side;
    }

    public String getSide() {
        return side;
    }
}
