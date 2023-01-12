package com.example.models;

import lombok.Getter;

@Getter
public enum AvatarEnum {
    DEURNAL("Deurnal--11"),
    NOXX("Noxx"),
    SOLARK("Solark"),
    SUNDOWNIX("Sundownix"),
    REVILLE("Reville"),
    EVENTIDEN("Eventiden"),
    SIESTAR("Siestar"),
    VESPIER("Vespier"),
    DAYSPRINZ("Daysprinz"),
    CREPUSCULES("Crepuscules"),
    FORTENOON("Fortenoon"),
    NIGHTFALT("Nightfalt");

    private String label;

    private AvatarEnum(String label) {
        this.label = label;
    }

}
