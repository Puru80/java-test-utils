package com.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvatarDescription {

    private String category;
    private String title;
    private String info;
}
