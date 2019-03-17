package Principal;

/*
Método: GET
Retorna as informações do hospital, por exemplo:

- Nome
- Endereço
- Número de leitos
- Números de leitos disponíveis
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
