package Principal;

/*
M�todo: GET
Retorna as informa��es do hospital, por exemplo:

- Nome
- Endere�o
- N�mero de leitos
- N�meros de leitos dispon�veis
* 
*/
public class Hospital {
	Long id;
	String Nome;
	String endereco;
	Long numLeitos;
	Long numLeitosDisponiveis;

	public Hospital(Long id, String nome, String endereco, Long numLeitos, Long numLeitosDisponiveis) {
		this.id = id;
		this.Nome = nome;
		this.endereco = endereco;
		this.numLeitos = numLeitos;
		this.numLeitosDisponiveis = numLeitosDisponiveis;
	}

}
