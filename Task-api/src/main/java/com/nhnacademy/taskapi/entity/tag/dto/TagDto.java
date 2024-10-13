package com.nhnacademy.taskapi.entity.tag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDto {

    private String content;

    public TagDto() {

    }

    public TagDto(String content) {
        this.content = content;
    }
}
