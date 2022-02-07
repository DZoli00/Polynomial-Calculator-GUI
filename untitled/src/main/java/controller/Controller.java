package controller;

import model.InvalidInputException;
import view.View;
import model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller{

    private View view;

    public Controller(View v){
        this.view = v;
        this.view.setSumator(new Sumator());
        this.view.setScazator(new Scazator());
        this.view.setImpatitor(new Impartitor());
        this.view.setInmultitor(new Inmultitor());
        this.view.setDerivare(new Derivare());
        this.view.setIntegrare(new Integrare());
        this.view.setReset(new Reset());

    }

    public View getView() {
        return view;
    }


   class Sumator implements ActionListener{
        public Sumator() {
        }
        @Override
        public void actionPerformed(ActionEvent e) {
             Polinom polIntrodus = new Polinom();
             Polinom polIntrodus2 = new Polinom();
            int ok = 0;
            int ok2= 0;
            try {
                polIntrodus.citeste(view.getText1().getText());
                ok = 1;
            } catch (InvalidInputException invalidInputException) {
                view.getText1().setText("Invalid input");
                view.getTextRest().setText("");
            }
            try {
                polIntrodus2.citeste(view.getText2().getText());
                ok2 = 1;
            } catch (InvalidInputException invalidInputException) {
                view.getText2().setText("Invalid input");
                view.getTextRest().setText("");
            }
            if( ok==1 && ok2==1) {
                polIntrodus.adunPolinom(polIntrodus2);
                view.getText1().setText(polIntrodus.toString());
                view.getTextRest().setText("");
                view.getTextRest().setText("");
            }
        }
    }


    class Reset implements ActionListener{

        Reset() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom polIntrodus = new Polinom();
            Polinom polIntrodus2 = new Polinom();
            view.getText1().setText("");
            view.getTextRest().setText("");
            view.getText2().setText("");
        }

    }

   class Scazator implements ActionListener{

        public Scazator() {
        }
       @Override
       public void actionPerformed(ActionEvent e) {
           Polinom polIntrodus = new Polinom();
           Polinom polIntrodus2 = new Polinom();

           int ok = 0;
           int ok2= 0;
           try {
               polIntrodus.citeste(view.getText1().getText());
               ok = 1;
           } catch (InvalidInputException invalidInputException) {
               view.getText1().setText("Invalid input");
               view.getTextRest().setText("");
           }
           try {
               polIntrodus2.citeste(view.getText2().getText());
               ok2 = 1;
           } catch (InvalidInputException invalidInputException) {
               view.getText2().setText("Invalid input");
               view.getTextRest().setText("");
           }
           if( ok==1 && ok2==1) {
               polIntrodus.scadPolinom(polIntrodus2);
               view.getText1().setText(polIntrodus.toString());
               view.getTextRest().setText("");
           }
       }
    }

   class Inmultitor implements ActionListener{

        public Inmultitor() {
        }
        @Override
            public void actionPerformed(ActionEvent e) {
            Polinom polIntrodus = new Polinom();
            Polinom polIntrodus2 = new Polinom();

                int ok = 0;
                int ok2= 0;
                try {
                    polIntrodus.citeste(view.getText1().getText());
                    ok = 1;
                } catch (InvalidInputException invalidInputException) {
                    view.getText1().setText("Invalid input");
                    view.getTextRest().setText("");
                }
                try {
                    polIntrodus2.citeste(view.getText2().getText());
                    ok2 = 1;
                } catch (InvalidInputException invalidInputException) {
                    view.getText2().setText("Invalid input");
                    view.getTextRest().setText("");
                }
                if( ok==1 && ok2==1) {
                    polIntrodus.inmultescPolinom(polIntrodus2);
                    view.getText1().setText(polIntrodus.toString());
                    view.getTextRest().setText("");
                }
            }
    }

    class Impartitor implements ActionListener{

        public Impartitor() {
        }
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom polIntrodus = new Polinom();
                Polinom polIntrodus2 = new Polinom();

                int ok = 0;
                int ok2= 0;
                try {
                    polIntrodus.citeste(view.getText1().getText());
                    ok = 1;
                } catch (InvalidInputException invalidInputException) {
                    view.getText1().setText("Invalid input");
                    view.getTextRest().setText("");
                }
                try {
                    polIntrodus2.citeste(view.getText2().getText());
                    ok2 = 1;
                } catch (InvalidInputException invalidInputException) {
                    view.getText2().setText("Invalid input");
                    view.getTextRest().setText("");
                }
                if( ok==1 && ok2==1) {
                    try {
                        polIntrodus.impartPolinom(polIntrodus2);
                    } catch (InvalidInputException invalidInputException) {
                        view.getText2().setText("Invalid input");
                        view.getTextRest().setText("");
                    }
                    view.getText1().setText(polIntrodus.toString());
                    view.getTextRest().setText("Rest: "+(polIntrodus2.toString()));
                }
            }

    }

    class Derivare implements ActionListener{

        public Derivare() {
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom polIntrodus = new Polinom();
            Polinom polIntrodus2 = new Polinom();
            int ok = 0;
            try {
                polIntrodus.citeste(view.getText1().getText());
                view.getTextRest().setText("");
                ok = 1;
            } catch (InvalidInputException invalidInputException) {
                view.getText1().setText("Invalid input");
                view.getTextRest().setText("");
            }
            if( ok==1 ) {
                polIntrodus.derivPolinom();
                view.getText1().setText(polIntrodus.toString());
                view.getTextRest().setText("");
            }
        }
    }

    class Integrare implements ActionListener{

        public Integrare() {
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom polIntrodus = new Polinom();
            Polinom polIntrodus2 = new Polinom();

            int ok = 0;
            try {
                polIntrodus.citeste(view.getText1().getText());
                ok = 1;
            } catch (InvalidInputException invalidInputException) {
                view.getText1().setText("Invalid input");
                view.getTextRest().setText("");
            }
            if( ok==1 ) {
                polIntrodus.integrPolinom();
                view.getText1().setText(polIntrodus.toString());
                view.getTextRest().setText("");
            }
        }
    }
}
