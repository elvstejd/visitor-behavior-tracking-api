package com.elvstejd.visitorbehaviortrackingapi.exception;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ApiError {
    private Integer status;
    private List<String> errors;

    public ApiError() {
        super();
    }

    public ApiError(final Integer status, final List<String> message) {
        super();
        this.status = status;
        this.errors = message;
    }
}
