import java.util.Collection;

public class Monom implements Comparable{
    private int power;
    private int coef;
    private boolean added;//added imi spune daca am lucrat deja cu monomul acesta, este folosita in adunare si scadere

    public Monom() { //constructir fara parametrii
    }

    public Monom(int power, int coef) {//constructor cu parametrii
        this.power = power;
        this.coef = coef;
    }
    //getteri si setteri pentru variabile
    public int getPower() {
        return power;
    }

    public int getCoef() {
        return coef;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public String toString( )//metoda toString transforma un Monom in string
    {
        if( coef == 0 && power == 0 )
            return "";

        if( coef == 0 )
            return "";

        if( power == 0 && coef > 0 )
            return "+" + coef ;

        if( power == 0 && coef < 0 )
            return  coef + "";

        if( coef == 1 && power>1 )
            return "+X^"+power;
        if( coef == -1 && power>1 )
            return "-X^"+power;

        if( coef == 1 && power == 1 )
            return "+X";

        if( power > 0 && coef > 0 )
            return "+" + coef + "X^" + power;
        else
            return coef + "X^" + power;
    }

    @Override
    public int compareTo(Object comparemon) {//metoda compareTo necesara pentru a putea sorta o lista de monoame
        int comparepow=((Monom)comparemon).getPower();
        return comparepow-this.power;
    }
}
