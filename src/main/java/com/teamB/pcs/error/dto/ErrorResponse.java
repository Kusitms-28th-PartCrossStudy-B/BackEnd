package com.teamB.pcs.error.dto;

public record ErrorResponse(int code, String message) {
    public static ErrorResponse of(int code, String message){
        return new ErrorResponse(code, message);
    }

}
