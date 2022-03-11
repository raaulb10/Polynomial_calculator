import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polinom{
    ArrayList<Monom> polinom;

    public Polinom( )
    {
        polinom = new ArrayList<Monom>( );
    }

    public List<Monom> getPolinom( )
    {
        return polinom;
    }

    public void add( Monom a )//adauga monomul a in polinom
    {
        polinom.add( a );
    }

    public void printList() {// printeaza lista de polinoame, am folosit-o pentru a testa inainte sa am interfata grafica
        for (Monom elem : polinom) {
            System.out.print(elem + "  ");
        }
    }
    public String writeListstring(){//metoda returneaza un string care contine toate monoamele din polinom, este folosita in gui pentru afisarea rezultatului
        String s="";
        for(Monom elem:polinom){
            s=s+" "+elem;
        }
        return s;
    }
    public void sort(){//metoda de sortare a polinomului
        Collections.sort(polinom);
    }

    public int getsize() {
        return polinom.size();
    }

    public Monom getM(int i) {
        return polinom.get(i);
    }

    public void removeM(Monom monom) {
        polinom.remove(monom);
    }
    public void removei(int i){
        polinom.remove(i);
    }

    public void empty(){
        polinom.clear();
    }
}

