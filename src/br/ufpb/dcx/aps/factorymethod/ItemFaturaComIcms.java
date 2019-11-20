package br.ufpb.dcx.aps.factorymethod;

public class ItemFaturaComIcms extends ItemFatura {

	private double taxaIcms;

	public ItemFaturaComIcms(Produto produto, int quantidade, double taxaIcms) {
		super(produto, quantidade);
		this.taxaIcms = taxaIcms;
	}

	@Override
	public double getSubTotal() {
		double precoComIcms = getProduto().getPreco() * (1 + taxaIcms);
		return (Math.floor(precoComIcms  * 100) / 100) * getQuantidade();
	}
}
