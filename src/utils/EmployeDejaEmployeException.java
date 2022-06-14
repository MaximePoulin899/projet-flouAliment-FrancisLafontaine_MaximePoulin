package utils;

import modele.Employe;

public class EmployeDejaEmployeException extends Exception{
    private Employe employe;

    public EmployeDejaEmployeException(Employe employe) {
        this.employe = employe;
    }

    public EmployeDejaEmployeException(String message, Employe employe) {
        super(message);
        this.employe = employe;
    }

    public Employe getEmploye() {
        return employe;
    }


    @Override
    public String toString() {
        return "ExceptionEmployeDejaEmploye{" +
                "employe=" + employe.toString() +
                '}';
    }
}
