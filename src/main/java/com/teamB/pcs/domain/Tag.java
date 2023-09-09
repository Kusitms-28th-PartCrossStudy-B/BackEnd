package com.teamB.pcs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.teamB.pcs.error.ErrorCode;
import com.teamB.pcs.error.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum Tag {
    STUDY, HEALTH, DRINK, OTHER;

    @JsonCreator
    public static List<Tag> create(List<String> requestValue) {
        List<Tag> tags = new ArrayList<>();
        for (String r : requestValue) {
            Tag tag = Stream.of(values())
                    .filter(v -> v.toString().equalsIgnoreCase(r))
                    .findFirst()
                    .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_TAG));
            tags.add(tag);
        }
        return tags;
    }

}
