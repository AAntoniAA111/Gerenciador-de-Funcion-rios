public class Gerente extends Funcionarios{
    private double bonusPercentual;

    public Gerente(String nome, String cpf, double salarioBase, double bonusPercentual){
        super(nome, cpf, salarioBase);
        this.bonusPercentual = bonusPercentual;
    }
    @Override
    public double calcularSalario(){
        return getSalarioBase() + (getSalarioBase() * bonusPercentual / 100);
    }
}
