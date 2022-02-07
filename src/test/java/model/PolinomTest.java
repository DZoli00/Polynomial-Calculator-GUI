package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolinomTest {

    private Polinom p1 = new Polinom();
    private Polinom p2 = new Polinom();

    @Test
    public void citireSiAfisarePolinomTest(){
        try {
            p1.citeste("x*^2-x+2");
        }catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }

        assertEquals("+1.0*x^2-1.0*x+2.0",p1.toString());

    }

    @Test
    public void addPolinomTest(){
        try {
            p1.citeste("4*x^5-3*x^4+x^2-8*x+1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        try {
            p2.citeste("3*x^4-x^3+x^2+2*x-1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.adunPolinom(p2);
        assertEquals("+4.0*x^5-1.0*x^3+2.0*x^2-6.0*x",p1.toString());
    }

    @Test
    public void subPolinomTest(){
        try {
            p1.citeste("4*x^5-3*x^4+x^2-8*x+1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        try {
            p2.citeste("3*x^4-x^3+x^2+2*x-1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.scadPolinom(p2);
        assertEquals("+4.0*x^5-6.0*x^4+1.0*x^3-10.0*x+2.0", p1.toString());
    }

    @Test
    public void inmultirePolinomTest(){
        try {
            p1.citeste("3*x^2-x+1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        try {
            p2.citeste("x-2");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.inmultescPolinom(p2);
        assertEquals("+3.0*x^3-7.0*x^2+3.0*x-2.0", p1.toString());
    }

    @Test
    public void impartirePolinomTest() throws InvalidInputException {
        try {
            p1.citeste("x^3-2*x^2+6*x-5");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        try {
            p2.citeste("x^2-1");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.impartPolinom(p2);
        assertEquals("+1.0*x-2.0", p1.toString());
        assertEquals("+7.0*x-7.0",p2.toString());
    }

    @Test
    public void derivarePolinomTest(){
        try {
            p1.citeste("x^3-2*x^2+6*x-5");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.derivPolinom();
        assertEquals("+3.0*x^2-4.0*x+6.0", p1.toString());
    }

    @Test
    public void integrarePolinomTest(){
        try {
            p1.citeste("x*^3+4x^2+5");
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input");
        }
        p1.integrPolinom();
        assertEquals("+0.25*x^4+1.33*x^3+5.0*x", p1.toString());
    }

}
