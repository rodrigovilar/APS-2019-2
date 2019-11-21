package br.ufpb.dcx.aps.factorymethod;

public class FaturaComIcms extends FaturaSimples {

	private double taxaIcms;

	public FaturaComIcms(double taxaIcms) {
		this.taxaIcms = taxaIcms;
	}
	
	protected ItemFatura criarItemFatura(int sequencia, Produto produto, int quantidade) {
		return new ItemFaturaComIcms(sequencia, produto, quantidade, taxaIcms);
	}

}
