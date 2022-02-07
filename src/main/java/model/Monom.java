package model;

import java.text.DecimalFormat;

public class Monom implements Comparable<Monom>{
    private int grad;
    private double coeficient;

    public Monom(int g, double coef){
        this.grad = g;
        this.coeficient = coef;
    }

    public double getCoeficient(){
        return coeficient;
    }

    public void setCoeficient(double c){
        this.coeficient = c;
    }

    public int getGrad(){
        return grad;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        if(this.grad == 0){
            if(this.coeficient > 0)
                return "+" + Double.valueOf(df.format(this.coeficient)) + "";
            else {
                return Double.valueOf(df.format(this.coeficient)) + "";
            }
        }
        if(this.grad == 1){
            if(this.coeficient > 0)
                return "+" + Double.valueOf(df.format(this.coeficient)) + "*x";
            else {
                return Double.valueOf(df.format(this.coeficient)) + "*x";
            }
        }
        else {
            if(this.coeficient > 0) {
                return "+" + Double.valueOf(df.format(this.coeficient)) + "*x^" + this.grad + "";
            }
            else {
                return Double.valueOf(df.format(this.coeficient)) + "*x^" + this.grad + "";
            }
        }
    }

    @Override
    public int compareTo(Monom o) {
        if(this.grad > o.getGrad())
            return -1;
        if( this.grad == o.grad){
            return 0;
        }
        return 1;
    }
}
