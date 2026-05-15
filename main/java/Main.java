import java.util.ArrayList;
import java.util.List;

public static void main(String[] args){
    Funcionarios g = new Gerente("Alexander", "468.821.8762-84", 7.000, 20);
    Funcionarios d = new Desenvolvedor("Channel", "786.469.783-47", 9.000, "pleno");
    Funcionarios e = new Estagiario("Dior", "759.314.569-85", 1.650, 30);

    List<Funcionarios> lista = new ArrayList<>();
    lista.add(g);
    lista.add(d);
    lista.add(e);
    for(Funcionarios f : lista){
        f.exibirInfo();
        System.out.println("----------");
    }

}