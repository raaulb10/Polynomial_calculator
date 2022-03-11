public class Main {
        public static void main(String[] args) {
                //implementare MCV in main
        Polinom pol1=new Polinom();
        Polinom pol2=new Polinom();
        View view=new View();
        Controller controller=new Controller(pol1,pol2,view);
        view.setVisible(true);

    }
}
