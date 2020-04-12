
public class Processo implements Comparable<Processo>{

	private String identificador;
	private int prioridade;
	private int tempoDeExecucao;
	private int tamanho;

	public Processo(String identificador, int prioridade, int tempoDeExecucao, int tamanho) {
		super();
		this.identificador = identificador;
		this.prioridade = prioridade;
		this.tempoDeExecucao = tempoDeExecucao;
		this.tamanho = tamanho;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getTempoDeExecucao() {
		return tempoDeExecucao;
	}

	public void setTempoDeExecucao(int tempoDeExecucao) {
		this.tempoDeExecucao = tempoDeExecucao;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + prioridade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (prioridade != other.prioridade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Processo " + identificador + " sendo executado, prioridade " + prioridade + ", tempo de execução " + tempoDeExecucao
				+ ", tamanho " + tamanho;
	}

	@Override
	public int compareTo(Processo o) {
		return this.prioridade - o.prioridade;
	}

}