public abstract class Funcionarios {
    private int id;
    private String nome;
    private String cpf;
    private double salarioBase;

    public Funcionarios(String nome, String cpf, double salarioBase){
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }

    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public double getSalarioBase(){
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase){
        if(salarioBase > 0){
            this.salarioBase = salarioBase;
        } else {
            IO.print("Salário inválido!");
        }
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //METODO ABSTRATO
    public abstract double calcularSalario();

    public void exibirInfo(){
        System.out.printf("Nome: " + nome);
        System.out.println("Salário: " + calcularSalario());
    }
}
