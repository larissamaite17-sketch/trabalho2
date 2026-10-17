package dao;

import model.Instrumento;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDAO {

    public void cadastrar(Instrumento instrumento) throws SQLException {
        String sql = "INSERT INTO instrumento (nome, marca, categoria, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getMarca());
            stmt.setString(3, instrumento.getCategoria());
            stmt.setDouble(4, instrumento.getPreco());
            stmt.setInt(5, instrumento.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public List<Instrumento> listar() throws SQLException {
        List<Instrumento> lista = new ArrayList<>();
        String sql = "SELECT * FROM instrumento";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Instrumento i = new Instrumento(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
                );
                lista.add(i);
            }
        }
        return lista;
    }

    public Instrumento buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM instrumento WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Instrumento(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("categoria"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                    );
                }
            }
        }
        return null;
    }

    public void atualizar(Instrumento instrumento) throws SQLException {
        String sql = "UPDATE instrumento SET nome = ?, marca = ?, categoria = ?, preco = ?, quantidade = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getMarca());
            stmt.setString(3, instrumento.getCategoria());
            stmt.setDouble(4, instrumento.getPreco());
            stmt.setInt(5, instrumento.getQuantidade());
            stmt.setInt(6, instrumento.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM instrumento WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}