import java.util.Collection;
import java.util.*;

public class Operatii {

    public static Polinom add( Polinom pol1 ,Polinom pol2 )//metoda de adunare a doua polinoame
    { Monom rezultatMono;
        Polinom rezultatPoli = new Polinom( );
        for( Monom m1 : pol1.getPolinom() ){ m1.setAdded(false); }//setez variabila buleana pe false inainte sa incep sa adun monoamele
        for( Monom m2 : pol2.getPolinom() ){ m2.setAdded(false); }// trbuie pusa pe 0 pentru ca daca facem scadere si pe urma adunare aceasta va fi true si operatia nu va functiona bine
        for( Monom m1 : pol1.getPolinom() )
        { for( Monom m2 : pol2.getPolinom() )//parcurgem pe rand monoamele celor doua polinoame
            { if( m1.getPower() == m2.getPower() )//daca au acelasi exponent le adunam in rezultat si notam ca le-am prelucrat
                { m1.setAdded( true );
                m2.setAdded( true );
                rezultatMono = new Monom( m1.getPower( ),m1.getCoef( ) + m2.getCoef( ) );//se vor aduna doar coeficientii si exponentul va ramane neschimbat
                rezultatPoli.add(rezultatMono); } } }
        for( Monom m1 : pol1.getPolinom() )//parcurgem pol1 si daca intalnim un element neadaugat il adaugam in rezultat
        { if( m1.isAdded() == false ) { rezultatPoli.add( m1 );m1.setAdded(true);} }
        for( Monom m2 : pol2.getPolinom() )//parcurgem pol2 si daca intalnim un element neadaugat il adaugam in rezultat
        { if( m2.isAdded() == false ) { rezultatPoli.add( m2 );m2.setAdded(true); } }
        rezultatPoli.sort();//sortam rezultatul si il returnam
        return rezultatPoli;
    }

    public static Polinom subtract(Polinom pol1 , Polinom pol2 )//operatia de scadere este aproape la fel cu cea de adunare
    { Monom rezultatMono;
        Polinom rezultatPoli = new Polinom( );
        for( Monom m1 : pol1.getPolinom() ){ m1.setAdded(false); }
        for( Monom m2 : pol2.getPolinom() ){ m2.setAdded(false); }
        for( Monom m1 : pol1.getPolinom() )
        { for( Monom m2 : pol2.getPolinom() ) {
            if (m1.getPower() == m2.getPower()) {
                m1.setAdded(true);
                m2.setAdded(true);
                rezultatMono = new Monom(m1.getPower(), m1.getCoef() - m2.getCoef());//diferenta este ca scadem coeficientii
                rezultatPoli.add(rezultatMono); } } }
        for( Monom m1 : pol1.getPolinom() )
        { if( m1.isAdded() == false ) { rezultatPoli.add( m1 );m1.setAdded(true); } }

        for( Monom m2 : pol2.getPolinom() )
        {if( m2.isAdded() == false ) {
                m2.setCoef(m2.getCoef()*(-1));//si la adaugarea coeficientilor ramasi neprelucrarti din pol2 ii inmultim cu -1
                rezultatPoli.add( m2 );
                m2.setAdded(true); } }
        rezultatPoli.sort();
        return rezultatPoli;
    }

    public static Polinom multiply(Polinom pol1 , Polinom pol2 ) {
        Monom rezultatMono;
        Polinom rezultatPoli = new Polinom();
        for( Monom m1 : pol1.getPolinom() ) {
            for (Monom m2 : pol2.getPolinom()) {//la operatia de inmultire parcurgem elemetele celor doua polinome si
                rezultatMono = new Monom(m1.getPower()+m2.getPower(), m1.getCoef() * m2.getCoef());//inmultim coeficientii si aduanm puterile
                Polinom polinom1=new Polinom();
                polinom1.add(rezultatMono);
                rezultatPoli=add(rezultatPoli,polinom1);
            }
        }
        rezultatPoli.sort();//sortam rezultatul si il returnam
        return rezultatPoli;
    }

    public static Polinom derivative( Polinom pol1 )
    {
        Monom rezultatMono;
        Polinom rez = new Polinom();

        for( Monom m1 : pol1.getPolinom() )
        {
            rezultatMono = new Monom( m1.getPower() - 1,m1.getCoef() * m1.getPower() );//pentru derivare parcurgem monoamele pe rand
                                                                                                  // scadem puterea cu 1 si inmultim coeficientul cu puterea

            //m1.setCoef( m1.getCoef() * m1.getPower());     //aceasta implementare poate calcula derivate de grad mai mare daca apasam pe buton de mai multe ori, dar schimba polinomul initial
            //m1.setPower(m1.getPower() - 1 );

            rez.add(rezultatMono);
        }
        return rez;
    }

    public static Polinom divide(Polinom pol1 , Polinom pol2 ) {

        Polinom catPoli = new Polinom();
        Monom m2=pol2.getM(0);
        Monom m1=pol1.getM(0);//luam primele monoame din cele doua polinoame
        while(m2.getPower()<=m1.getPower()){//verificam ca exponentul lui m2 sa fie mai mic decat al lui m1
            Monom rezultatMono;
            rezultatMono=new Monom();
            if(m2.getCoef()!=0){//daca coeficientul este diferit de 0 efecuam impartirea scazand puterea si impartind coeficientii
                rezultatMono.setPower(m1.getPower()-m2.getPower());
                rezultatMono.setCoef(m1.getCoef() / m2.getCoef());

                Polinom polinom1=new Polinom();
                polinom1.add(rezultatMono);
                catPoli=add(catPoli,polinom1);
            }
            if(rezultatMono.getCoef()!=0||rezultatMono.getPower()!=0) {//daca s-a efectuat impartirea dinainte
                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();
                polinom2.add(rezultatMono);
                polinom1 = multiply(pol2, polinom2);//inmultim catul obtinut inainte cu impartitorul
                pol1 = subtract(pol1, polinom1);//scadem din deimpartit
                pol1.sort();//sortam noul polinom
                pol1.removei(0);//excludem coeficientul cu care am lucrat deja si il luam pe urmatorul
                //pol1.printList();
                m1=pol1.getM(0);
            }
        }
        return catPoli;//returnam catul
    }

    public static Polinom reminder(Polinom pol1 , Polinom pol2 ) {//aceeasi functie de mai sus dar se returneaza restul
        Monom rezultatMono;
        Polinom catPoli = new Polinom();
        rezultatMono=new Monom();
        Monom m2=pol2.getM(0);
        Monom m1=pol1.getM(0);
        while(m2.getPower()<=m1.getPower()){
            if(m2.getCoef()!=0){
                rezultatMono.setPower(m1.getPower()-m2.getPower());
                rezultatMono.setCoef(m1.getCoef() / m2.getCoef());
                Polinom polinom1=new Polinom();
                polinom1.add(rezultatMono);
                catPoli=add(catPoli,polinom1); }
            if(rezultatMono.getCoef()!=0||rezultatMono.getPower()!=0) {
                Polinom polinom1 = new Polinom();
                Polinom polinom2 = new Polinom();
                polinom2.add(rezultatMono);
                polinom1 = multiply(pol2, polinom2);
                pol1 = subtract(pol1, polinom1);
                pol1.sort();
                pol1.removei(0);
                //pol1.printList();
                m1=pol1.getM(0); } }
        return pol1;
    }

    public static PolinomDouble integral(Polinom pol1){
        PolinomDouble rez=new PolinomDouble();
        for( Monom m1 : pol1.getPolinom() )
        {// parcurgem pe rand monoamele si le integram adunand 1 la expoenent si impartind coeficientul cu exponentul+1
            MonomDouble monom=new MonomDouble(m1.getPower()+1,(double)m1.getCoef()/(m1.getPower()+1));
            rez.add(monom);
        }
        rez.sort();
        return rez;
    }
}
