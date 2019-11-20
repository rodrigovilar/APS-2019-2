package br.ufpb.dcx.aps.factorymethod;

public class ItemFaturaComIcms extends ItemFatura {

	private double taxaIcms;

	public ItemFaturaComIcms(Produto produto, int quantidade, double taxaIcms) {
		super(produto, quantidade);
		this.taxaIcms = taxaIcms;
	}

	@Override
	public double getSubTotal() {
		return Math.floor(super.getSubTotal() * (1 + taxaIcms) * 100) / 100;
	}
}
