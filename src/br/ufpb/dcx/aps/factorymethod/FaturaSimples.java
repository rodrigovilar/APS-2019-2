package br.ufpb.dcx.aps.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class FaturaSimples {
	
	
	protected List<ItemFatura> itens = new ArrayList<ItemFatura>();

	public void addItem(Produto produto, int quantidade) {
		ItemFatura itemFatura = criarItemFatura(itens.size() + 1, produto, quantidade);
		itens.add(itemFatura);
	}

	protected ItemFatura criarItemFatura(int sequencia, Produto produto, int quantidade) {
		return new ItemFatura(sequencia, produto, quantidade);
	}

	@Override
	public String toString() {
		String resultado = "";
		double total = 0.0;
		
		for (int i = 0; i < itens.size(); i++) {
			ItemFatura item = itens.get(i);
			resultado += item;
			total += item.getSubTotal();
		}
		
		resultado += 
				"Total : " + String.format("%.2f", total);
		
		return resultado;
	}
}
