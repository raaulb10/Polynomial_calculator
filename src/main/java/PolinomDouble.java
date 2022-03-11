import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolinomDouble {
    ArrayList<MonomDouble> polinom;

    public PolinomDouble( ) { polinom = new ArrayList<MonomDouble>( ); }

    public List<MonomDouble> getPolinom( ) { return polinom; }

    public void add( MonomDouble a )
    {
        polinom.add( a );
    }

    public void printList() {
        for (MonomDouble elem : polinom) {
            System.out.print(elem + "  ");
        }
    }
    public String writeListstring(){
        String s="";
        for(MonomDouble elem:polinom){
            s=s+" "+elem;
        }
        return s;
    }
    public void sort(){
        Collections.sort(polinom);
    }
}
