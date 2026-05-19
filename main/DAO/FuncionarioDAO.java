import java.sql.*;

class FuncionarioDAO {
    public void salvar(Funcionarios f){
        Connection conn = ConexaoDB.getConexao();

        if(conn == null){
            System.out.println("Cadastro não salvo no banco: sem conexão.");
            return;
        }

        String sql = "INSERT INTO funcionarios (nome, cpf, " +
                "salario_base, tipo, " +
                "bonus_percentual, senioridade, carga_horaria) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try{ //ONDE TUDO FUNCIONA NORMALMENTE
            PreparedStatement stmt = conn.prepareStatement(sql);
            //>>stmt<< PREENCHE OS ESPAÇOS "?", RESERVADOS PARA O SQL
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setDouble(3, f.getSalarioBase());

            if(f instanceof Gerente){
                Gerente g = (Gerente) f;
                stmt.setString(4, "gerente");
                stmt.setDouble(5, g.getBonusPercentual());
                stmt.setNull(6, Types.VARCHAR);
                stmt.setNull(7, Types.INTEGER);
            } else if (f instanceof Desenvolvedor){
                Desenvolvedor d = (Desenvolvedor) f;
                stmt.setString(4, "desenvolvedor");
                stmt.setNull(5, Types.DOUBLE);
                stmt.setString(6, d.getNivelSenioridade());
                stmt.setNull(7, Types.INTEGER);
            } else if (f instanceof Estagiario){
                Estagiario e = (Estagiario) f;
                stmt.setString(4, "estagiario");
                stmt.setNull(5, Types.DOUBLE);
                stmt.setNull(6, Types.VARCHAR);
                stmt.setInt(7, e.getCargaHoraria());
            }

            stmt.executeUpdate(); //ENVIA O INSERT PARA O BANCO
            stmt.close(); //FECHA O PreparedStatement
            conn.close(); //FECHA A CONECXÃO COM O BANCO
            //SEMPRE FECHAR O >>stmt<< e >>conn<< POIS SE NÃO FECHAR
            //FICARÁ DESPERDIÇANDO RECURSOS

        } catch (SQLException e){ //ONDE ALGO DEU ERRADO
            System.out.println("Erro ao salvar: " + e.getMessage());
        }


    }
}
