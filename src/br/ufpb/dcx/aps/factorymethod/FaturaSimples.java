package br.ufpb.dcx.aps.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class FaturaSimples {
	
	
	protected List<ItemFatura> itens = new ArrayList<ItemFatura>();

	public void addItem(Produto produto, int quantidade) {
		ItemFatura itemFatura = criarItemFatura(produto, quantidade);
		itens.add(itemFatura);
	}

	protected ItemFatura criarItemFatura(Produto produto, int quantidade) {
		return new ItemFatura(produto, quantidade);
	}

	@Override
	public String toString() {
		String esperado = "";
		int i = 1;
		double total = 0.0;
		
		for (ItemFatura item : itens) {
			Produto produto = item.getProduto();
			
			String preco = String.format("%.2f", produto.getPreco());
			String subTotal = String.format("%.2f", item.getSubTotal());
			
			String linha = i++ + ". " + produto.getNome() + 
					" " + preco + " x " + 
					item.getQuantidade() + " : " + subTotal + "\n";
			
			esperado += linha;
			total += item.getSubTotal();
		}
		
		esperado += 
				"Total : " + String.format("%.2f", total);
		
		return esperado;
	}
}
