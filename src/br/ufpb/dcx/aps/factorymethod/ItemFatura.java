package br.ufpb.dcx.aps.factorymethod;

public class ItemFatura {

	private Produto produto;
	private int quantidade;
	private int sequencia;

	public ItemFatura(int sequencia, Produto produto, int quantidade) {
		this.sequencia = sequencia;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public int getSequencia() {
		return sequencia;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getSubTotal() {
		return Math.floor(produto.getPreco() * quantidade * 100) / 100 ;
	}

	@Override
	public String toString() {
		
		String subTotal = String.format("%.2f", getSubTotal());
		
		String linha = sequencia + ". " + produto.getNome() + 
				" " + montarPreco(produto) + " x " + 
				getQuantidade() + " : " + subTotal + "\n";
		
		return linha;
	}

	protected String montarPreco(Produto produto) {
		return String.format("%.2f", produto.getPreco());
	}

}
