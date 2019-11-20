package br.ufpb.dcx.aps.factorymethod;

public class ItemFatura {

	private Produto produto;
	private int quantidade;

	public ItemFatura(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getSubTotal() {
		return Math.floor(produto.getPreco() * quantidade * 100) / 100 ;
	}

}
