import java.util.ArrayList;
import java.util.List;
public class Main{
public static void main(String[] args){
    Funcionarios g = new Gerente("Alexander", "468.821.8762-84", 7000.0, 20);
    Funcionarios d = new Desenvolvedor("Channel", "786.469.783-47", 9000.0, "pleno");
    Funcionarios e = new Estagiario("Dior", "759.314.569-85", 1650.0, 30);

    List<Funcionarios> lista = new ArrayList<>();
    lista.add(g);
    lista.add(d);
    lista.add(e);
    for(Funcionarios f : lista){
        f.exibirInfo();
        System.out.println("----------");
    }
}
}