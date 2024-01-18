package net.javaguides.springboot.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDataDetails {

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCOde;
}
