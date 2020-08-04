package com.example.cursospring.domain.enums;

public enum ProfileType {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENT(2, "ROLE_CLIENT");

    private int cod;
    private String description;

    ProfileType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static ProfileType toEnum(Integer cod) {
        if(cod == null)
        {
            return null;
        }

        for(ProfileType x : ProfileType.values()) {
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + cod);
    }

}
