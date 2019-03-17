package Principal;

/*
Método: GET
Retorna todas as informações do paciente cadastrado, por exemplo:

- Nome completo
- CPF
- Data de nascimento
- Sexo
- Data de entrada no hospital.
*/
public class Paciente {
	Long id;
	String nome;
	String cpf;
	String dtNascimento;
	String sexo;
	String dtEntrada;

	public Paciente(Long id, String nome, String cpf, String dtNascimento, String sexo, String dtEntrada) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.dtEntrada = dtEntrada;
	}

}
