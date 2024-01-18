package net.javaguides.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String  fieldName;
    private Long fielValue;

   
    //Não gerar construtor pelo lombok, pois há uma alteração na mensagem vinda da super Class
    public ResourceNotFoundException(String resourceName, String fieldName, Long fielValue){
        super(String.format("%s not found with %s : %s",resourceName, fieldName ,fielValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fielValue = fielValue;

    }
}
