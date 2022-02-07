package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private ArrayList<Monom> lista = new ArrayList<>();

    public Polinom() {
    }

    public void adaugMonom(Monom m){
        lista.add(m);
    }
    public void stergMonom(Monom m) {
        lista.remove(m);
    }

    public ArrayList<Monom> getLista(){
        return lista;
    }

    @Override
    public String toString(){
        String polinomAfisare = new String("");
        for(Monom m: lista){
            polinomAfisare = polinomAfisare + m.toString();
        }
        return polinomAfisare;
    }

    public double citesteCoeficient(String s) throws InvalidInputException {
        double coeficientMonom;

        Pattern coef = Pattern.compile("([+-]?[^*x]+)");

        Matcher coefMonom = coef.matcher(s);
        if(coefMonom.find() && !coefMonom.group().contains("^")) {
            if(coefMonom.group().equals("-")){
                coeficientMonom = -1;
            } else {
                if(coefMonom.group().equals("+")){
                    coeficientMonom = 1;
                } else {
                        try{
                            coeficientMonom = Double.parseDouble(coefMonom.group());
                        } catch(NumberFormatException e){
                            throw new InvalidInputException("");
                        }
                }
            }
        } else{
            coeficientMonom = 1;
        }
        return coeficientMonom;
    }

    public int citesteGrad(String s) throws InvalidInputException {
        int gradMon;

        Pattern coef = Pattern.compile("([+-]?[^x]+)");
        Matcher coefMonom = coef.matcher(s);
        coefMonom.find();

        Pattern grad = Pattern.compile("([^^]?[0-9]+)");
        Matcher gradMonom = grad.matcher(s);
        gradMonom.find();
        Pattern grad1 = Pattern.compile("([.x]$)");
        Matcher gradMonom1 = grad1.matcher(s);
        if(gradMonom1.find()){
            gradMon = 1;
        }
        else{
            int end = coefMonom.end();
            if(coefMonom.group().contains("^")){
                end = 0;
            }
            if(gradMonom.find(end) && !gradMonom.group().contains(".") ) {
                try{
                    gradMon = Integer.parseInt(gradMonom.group());
                } catch(NumberFormatException e){
                    throw new InvalidInputException("");
                }
            }
            else{
                gradMon = 0;
            }
        }
        return gradMon;
    }

    public void citeste(String s) throws InvalidInputException {
        double coeficientMonom;
        int gradMon;
        Pattern p1 = Pattern.compile("([a-z&&[^x]])");
        Matcher m = p1.matcher(s);

        if(m.find() ){
            throw new InvalidInputException("");
        }
        p1 = Pattern.compile("([+-]?[^-+]+)");
        m = p1.matcher(s);
        while(m.find()){
            String monom = m.group();
            coeficientMonom = citesteCoeficient(monom);
            gradMon = citesteGrad(monom);
            this.adaugMonom(new Monom(gradMon,coeficientMonom));
        }
    }

    public void adunPolinom(Polinom p2) {
        Polinom rezultat = new Polinom();
        for( Monom x: this.lista ){
            int inserat = 0;
            for( Monom y: p2.lista ){
                if( x.getGrad() == y.getGrad()){
                    if(x.getCoeficient()+y.getCoeficient() != 0.0) {
                        rezultat.adaugMonom(new Monom(x.getGrad(), x.getCoeficient() + y.getCoeficient()));
                    }
                        inserat = 1;
                        p2.stergMonom(y);
                        break;
                }
            }
            if( inserat == 0){
                rezultat.adaugMonom(x);
            }
        }
        for(Monom y: p2.lista){
            rezultat.adaugMonom(y);
        }
        Collections.sort(rezultat.lista);
        this.lista = rezultat.lista;
    }

    public void scadPolinom(Polinom p2){
        for(Monom x: p2.lista){
            x.setCoeficient((-1)*x.getCoeficient());
        }
        this.adunPolinom(p2);
    }

    public void inmultescPolinom(Polinom p2){
        Polinom rezultat = new Polinom();

        for(Monom x: this.lista){
            Polinom intermediar = new Polinom();
            for( Monom y: p2.lista){
                intermediar.adaugMonom(new Monom(x.getGrad()+y.getGrad(),x.getCoeficient()*y.getCoeficient()));
            }
            rezultat.adunPolinom(intermediar);
        }
        this.lista = rezultat.lista;
    }

    public void derivPolinom(){
        Polinom rezultat = new Polinom();
        for(Monom x: this.lista){
            if(x.getGrad() != 0){
                rezultat.adaugMonom(new Monom(x.getGrad()-1,x.getCoeficient()* x.getGrad()));
            }
        }
        this.lista = rezultat.lista;
    }

    public void integrPolinom(){
        Polinom rezultat = new Polinom();
            for( Monom x: this.lista){
                rezultat.adaugMonom(new Monom(x.getGrad()+1,x.getCoeficient()/(x.getGrad()+1)));
            }
        this.lista = rezultat.lista;
    }

    public void impartPolinom(Polinom p2) throws InvalidInputException {
        Polinom rezultat = new Polinom();
        step:
        for(Monom x: this.lista){
            for( Monom y: p2.lista){
                if(x.getGrad() >= y.getGrad()){
                    Polinom intermediar = new Polinom();
                    Polinom inmult = new Polinom();
                    for(Monom z: p2.lista){
                        intermediar.adaugMonom(z);
                    }
                    if( y.getCoeficient() == 0){
                        throw new InvalidInputException("Division by zero");
                    }else
                    {
                        inmult.adaugMonom(new Monom(x.getGrad() - y.getGrad(), x.getCoeficient() / y.getCoeficient()));
                        rezultat.adaugMonom(new Monom(x.getGrad() - y.getGrad(), x.getCoeficient() / y.getCoeficient()));
                    }
                    intermediar.inmultescPolinom(inmult);
                    this.scadPolinom(intermediar);
                    continue step;
                }
                else{
                    break;
                }
            }
        }
        p2.lista = this.lista;
        this.lista = rezultat.lista;
    }

}

