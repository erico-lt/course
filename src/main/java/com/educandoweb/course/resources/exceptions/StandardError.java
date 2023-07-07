package com.educandoweb.course.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String erro;
    private String message;
    private String path;

    public StandardError() {        
    }

    public StandardError(Instant timestamp, Integer status, String erro, String message, String path) {
        this.setTimestamp(timestamp);
        this.setStatus(status);
        this.setErro(erro);
        this.setMessage(message);
        this.setPath(path);
    }
    
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "{\ntimestamp: " + timestamp + 
        "\nstatus: " + status + 
        "\nerro: " + erro +
        "\nmessage: " + message + 
        "\npath: " + path + "\n}";
    }  
    
}
