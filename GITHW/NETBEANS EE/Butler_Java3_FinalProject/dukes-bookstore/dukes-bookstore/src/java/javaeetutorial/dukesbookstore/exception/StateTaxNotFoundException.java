/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.exception;

/**
 *
 * @author tfran
 */
public class StateTaxNotFoundException extends Exception{
    private static final long serialVersionUID = 4156679698574326238L;

    public StateTaxNotFoundException() {
    }

    public StateTaxNotFoundException(String msg) {
        super(msg);
    }
}
