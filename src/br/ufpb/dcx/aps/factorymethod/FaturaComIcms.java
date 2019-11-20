package br.ufpb.dcx.aps.factorymethod;

public class FaturaComIcms extends FaturaSimples {

	private double taxaIcms;

	public FaturaComIcms(double taxaIcms) {
		this.taxaIcms = taxaIcms;
	}
	
	protected ItemFatura criarItemFatura(Produto produto, int quantidade) {
		return new ItemFaturaComIcms(produto, quantidade, taxaIcms);
	}


	@Override
	public String toString() {
		String esperado = "";
		int i = 1;
		double total = 0.0;
		
		for (ItemFatura item : itens) {
			Produto produto = item.getProduto();
			
			String preco = String.format("%.2f", produto.getPreco());
			double valorIcmsDouble = Math.floor((produto.getPreco() * taxaIcms) * 100) / 100;
			String valorIcms = String.format("%.2f", valorIcmsDouble);
			String subTotal = String.format("%.2f", item.getSubTotal());
			
			String linha = i++ + ". " + produto.getNome() + 
					" (" + preco + " + " + valorIcms + ") x " + 
					item.getQuantidade() + " : " + subTotal + "\n";
			
			esperado += linha;
			total += item.getSubTotal();
		}
		
		esperado += 
				"Total : " + String.format("%.2f", total);
		
//		"1. Arroz (0.50 + 0.05) x 2 : 1.10\n" +
//		"2. Batata (0.75 + 0.07) x 3 : 2.46\n" +
//		"3. Sal (2.00 + 0.20) x 1 : 2.20\n" +
//		"Total : 5.76";
		return esperado;
	}
}
