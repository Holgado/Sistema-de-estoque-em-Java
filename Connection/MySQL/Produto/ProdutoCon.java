package Connection.MySQL.Produto;

import Connection.MySQL.ConnectionFactory;
import java.sql.Connection;
import adm_eletronicos.Produto;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoCon {
    public void registrarDB(Produto p) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        // classe que monta a string que serve para rodar o comando SQL
        PreparedStatement stmt = null;
        // Cria a string para inserção no banco de dados
        String sql = "INSERT INTO produtos (nomeProduto,qntdProduto,precoUnidade) VALUES (?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);   
            // Coloca na posição 1 a informação do nome do produto            
            stmt.setString(1, p.getNome());                 
            // Coloca na posição 1 a informação do quantidade do produto
            stmt.setString(2, Integer.toString(p.getQuantidade()));
            // Coloca na posição 1 a informação do preço do produto
            stmt.setString(3, Double.toString(p.getPreco()));
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Os dados foram inseridos no banco de dados");
            
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao adicionar dados " + e.toString());
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public ArrayList<Produto> consultarDB() throws SQLException {
        
        String sql = "SELECT * FROM produtos";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);    
        ResultSet r_set = null;
        ArrayList<Produto> prods = new ArrayList<Produto>();
        try { 
            r_set = stmt.executeQuery();
               
            while(r_set.next()){
                Produto produto = new Produto();
                produto.setId(r_set.getInt(1));
                produto.setNome(r_set.getString(2));
                produto.setQuantidade(r_set.getInt(3));
                produto.setPreco(r_set.getDouble(4));
                
                prods.add(produto);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar " + e.toString());
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt);      
        }
        return prods;
    }
    public void removerDB(int id) throws SQLException {
        
        id = id+1;
        String sql = "DELETE FROM produtos WHERE produtos.idProduto = " + id;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);    
        try { 
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao remover do Banco " + e.toString());
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt);      
        }
    }
}
