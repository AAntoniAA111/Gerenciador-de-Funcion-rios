public class Estagiario extends Funcionarios{
    private int cargaHoraria;

    public Estagiario(String nome, String cpf, double salarioBase, int cargaHoraria) {
        super(nome, cpf, salarioBase);
        this.cargaHoraria = cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }

    @Override
    public double calcularSalario(){
        return (getSalarioBase() / 220) * getCargaHoraria() * 4;
    }
}
