public class MonomDouble implements Comparable{
    private int power;
    private double coef;
    private boolean added;

    public MonomDouble() {
    }

    public MonomDouble(int power, double coef) {
        this.power = power;
        this.coef = coef;
    }

    public int getPower() {
        return power;
    }

    public double getCoef() {
        return coef;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public String toString( )
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
            return "X";

        if( power > 0 && coef > 0 )
            return "+" + coef + "X^" + power;
        else
            return coef + "X^" + power;
    }

    @Override
    public int compareTo(Object comparemon) {
        int comparepow=((MonomDouble)comparemon).getPower();
        return comparepow-this.power;
    }
}