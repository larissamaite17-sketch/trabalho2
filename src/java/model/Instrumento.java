package model;

public class Instrumento {

    private int id;
    private String nome;
    private String marca;
    private String categoria;
    private double preco;
    private int quantidade;

    public Instrumento() {
    }

    public Instrumento(int id, String nome, String marca,
            String categoria, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}