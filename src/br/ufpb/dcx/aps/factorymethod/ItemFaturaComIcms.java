package br.ufpb.dcx.aps.factorymethod;

public class ItemFaturaComIcms extends ItemFatura {

	private double taxaIcms;

	public ItemFaturaComIcms(int sequencia, Produto produto, int quantidade, double taxaIcms) {
		super(sequencia, produto, quantidade);
		this.taxaIcms = taxaIcms;
	}

	@Override
	public double getSubTotal() {
		double precoComIcms = getProduto().getPreco() * (1 + taxaIcms);
		return (Math.floor(precoComIcms  * 100) / 100) * getQuantidade();
	}
	
	@Override
	protected String montarPreco(Produto produto) {
		String preco = String.format("%.2f", getProduto().getPreco());
		double valorIcmsDouble = Math.floor((getProduto().getPreco() * taxaIcms) * 100) / 100;
		String valorIcms = String.format("%.2f", valorIcmsDouble);
		
		return "(" + preco + " + " + valorIcms + ")";
	}
}
