public class Desenvolvedor extends Funcionarios {
    private String nivelSenioridade;

    public Desenvolvedor(String nome, String cpf, double salarioBase, String nivelSenioridade){
        super(nome, cpf, salarioBase);
        this.nivelSenioridade = nivelSenioridade;
    }

    public void setNivelSenioridade(String nivelSenioridade){
        this.nivelSenioridade = nivelSenioridade;
    }
    public String getNivelSenioridade(){
        return nivelSenioridade;
    }

    @Override
    public double calcularSalario(){
        if(nivelSenioridade.equals("senior")){
            return getSalarioBase() * 1.5;
        } else if (nivelSenioridade.equals("pleno")){
            return getSalarioBase() * 1.2;
        } else {
            return getSalarioBase();
        }
    }
}
