package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ErrorMessage<T> {
    private T body;
    private HttpStatus code;
    private LocalDateTime timeStamp;
}
