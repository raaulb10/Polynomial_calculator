import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private View view;
    private Polinom polinom1;
    private Polinom polinom2;
    private Polinom rez=new Polinom();
    private PolinomDouble rezdouble=new PolinomDouble();

    Controller(Polinom m_polinom1,Polinom m_polinom2,View m_view){
        view=m_view;
        polinom1=m_polinom1;
        polinom2=m_polinom2;

        view.addSubmit1Listener(new Submit1Listener());
        view.addSubmit2Listener(new Submit2Listener());
        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDerListener(new DerListener());
        view.addDivListener(new DivListener());
        view.addResListener(new ResListener());
        view.addIntListener(new IntListener());
    }

    class Submit1Listener implements ActionListener{//metoda pentru preluarea polinomului si transformarea lui din string in sir de monoame
        public void actionPerformed(ActionEvent e){
            String poli;
            Monom m;
            polinom1.empty();
            poli=view.getP1();
            //String replaced=poli.replace("-","+-");
            String[] coef=poli.split("x\\^\\d+\\+?");//luam coficientii polinomului folosind Regex
            String[] powers=poli.split("\\-?\\+?\\d+x\\^");//luam puterile
            for(int i=0;i<coef.length;i++){
                m=new Monom(Integer.parseInt(powers[i+1]),Integer.parseInt(coef[i]));//adaug cate un monom in polinomul1
                polinom1.add(m);
            }
            polinom1.sort();
        }
    }
    class Submit2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String poli;
            Monom m;
            polinom2.empty();
            poli=view.getP2();
            String[] coef=poli.split("x\\^\\d+\\+?");
            String[] powers=poli.split("\\-?\\+?\\d+x\\^");
            for(int i=0;i<coef.length;i++){
                m=new Monom(Integer.parseInt(powers[i+1]),Integer.parseInt(coef[i]));
                polinom2.add(m);
            }
            polinom2.sort();
        }
    }
    //urmatoarele functii apeleaza operatiile corespunzatoare si afiseaza rezultatul obtinut in format String
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.add(polinom1,polinom2);
            view.setRez(rez.writeListstring());
        }
    }
    class SubListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.subtract(polinom1,polinom2);
            view.setRez(rez.writeListstring());
        }
    }

    class MultiplyListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.multiply(polinom1,polinom2);
            view.setRez(rez.writeListstring());
        }
    }
    class DerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.derivative(polinom1);
            view.setRez(rez.writeListstring());
        }
    }
    class DivListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.divide(polinom1,polinom2);
            view.setRez(rez.writeListstring());
        }
    }
    class ResListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rez=Operatii.reminder(polinom1,polinom2);
            view.setRez(rez.writeListstring());
        }
    }
    class IntListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            rezdouble=Operatii.integral(polinom1);
            view.setRez(rezdouble.writeListstring()+" +C");
        }
    }
}
