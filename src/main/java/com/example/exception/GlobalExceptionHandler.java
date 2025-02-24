package com.example.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {


    private List<String> addValueToMap(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class) // fırlatılan exception'un class ismi
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){ // yakalanan exceptionu methoda parametre olarak geçti, değerlerine fieldlara vs erişmek için

        Map<String, List<String>> errorsMap = new HashMap<>();

        for (ObjectError objError : ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objError).getField();

            if (errorsMap.containsKey(fieldName)){
                errorsMap.put(fieldName, addValueToMap(errorsMap.get(fieldName), objError.getDefaultMessage()));
            }else {
                errorsMap.put(fieldName, addValueToMap(new ArrayList<>(), objError.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private <T> ApiError<T> createApiError(T errors){
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }


}
