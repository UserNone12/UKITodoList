package com.vvibu.todolist_3;

public class ToDo {
    String namaToDo;
    String StatusToDo;
    String idToDo;

    public ToDo() {

    }

    //untuk
    public ToDo(String namaToDo, String statusToDo, String idToDo) {
        this.namaToDo = namaToDo;
        StatusToDo = statusToDo;
        this.idToDo = idToDo;
    }

    public String getNamaToDo() {
        return namaToDo;
    }

    public void setNamaToDo(String namaToDo) {
        this.namaToDo = namaToDo;
    }

    public String getStatusToDo() {
        return StatusToDo;
    }

    public void setStatusToDo(String statusToDo) {
        StatusToDo = statusToDo;
    }

    public String getIdToDo() {
        return idToDo;
    }

    public void setIdToDo(String idToDo) {
        this.idToDo = idToDo;
    }

}
