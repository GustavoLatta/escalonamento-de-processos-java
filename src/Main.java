import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);

		// process variables 
		int  contadorVerificacao = 0;

		int NumProcessos, entrada, tempoAtual, execucao, idProcessoAtual, qteProcessos;
		
		ArrayList<Integer> ingressos, duracoes, prioridades, processos, copiaIngressos;
		int[] temposFinais, temposIniciais;
		String ordemExecucao, formato, saida;
		
		// formatter
		DecimalFormat formatador = new DecimalFormat("0.00");

		System.out.println("Bem vindo!\n Insira a quantidade de processos que deseja verificar:");
		NumProcessos = scanner.nextInt();

		while (NumProcessos != 0) {
			// Check counter
			contadorVerificacao++;

			// Instantiating arrayList
			processos = new ArrayList<Integer>();
			ingressos = new ArrayList<Integer>();
			duracoes = new ArrayList<Integer>();
			prioridades = new ArrayList<Integer>();

			// Process data storage
			for (int i = 0; i < NumProcessos; i++) {
				System.out.print("--------------------------- \n");
				System.out.println("Insira informações do PROCESSO " + (i + 1) + ":");
				System.out.print("Ingresso: ");
				entrada = scanner.nextInt();
				ingressos.add(entrada);
				System.out.print("Duração: ");
				entrada = scanner.nextInt();
				duracoes.add(entrada);
				System.out.print("Prioridade: ");
				entrada = scanner.nextInt();
				prioridades.add(entrada);
			}
			temposIniciais = new int[NumProcessos];
			temposFinais = new int[NumProcessos];

			ordemExecucao = "";
			copiaIngressos = (ArrayList) ingressos.clone();
			tempoAtual = (int) ingressos.get(0);

			qteProcessos = NumProcessos;
			
			// Current input process
			while (qteProcessos > 0) {
				processos = new ArrayList();
				for (int i = 0; i < NumProcessos; i++) {
					if (ingressos.get(i) != -1 && ingressos.get(i) <= tempoAtual) {
						processos.add(i);
					}
				}

				if (processos.isEmpty()) {
					tempoAtual++;
				} else {
					execucao = processos.get(0);
					for (int i = 0; i < processos.size(); i++) {
						idProcessoAtual = processos.get(i);
						if (prioridades.get(idProcessoAtual) < prioridades.get(execucao)) {
							execucao = processos.get(i);
						}
					}
					temposIniciais[execucao] = tempoAtual;
					tempoAtual += duracoes.get(execucao);

					temposFinais[execucao] = tempoAtual;
					ingressos.set(execucao, -1);

					// Execution order definition
					ordemExecucao += "Processo" + (execucao + 1) + " ";

					qteProcessos--;
				}
			}

			// Calculate run time and wait
			double tempoExecucao = 0, tempoEspera = 0;
			for (int i = 0; i < NumProcessos; i++) {
				tempoExecucao += temposFinais[i] - copiaIngressos.get(i);
				tempoEspera += temposIniciais[i] - copiaIngressos.get(i);
			}
			tempoExecucao = tempoExecucao / NumProcessos;
			tempoEspera = tempoEspera / NumProcessos;
			
			System.out.println();
			System.out.print("--------------------------- \n");
			System.out.println("Saída: ");
			System.out.println("Verificações: " + contadorVerificacao + ".");

			formato = formatador.format(tempoExecucao);
			saida = "Tempo médio de execução: " + formato + "s";
			saida = saida.replace(",", ".");
			System.out.println(saida);

			formato = formatador.format(tempoEspera);
			saida = "Tempo médio de espera: " + formato + "s";
			saida = saida.replace(",", ".");
			System.out.println(saida);

			System.out.println("Ordem de execução dos PROCESSOS: " + ordemExecucao);
			System.out.println();
			System.out.print("0 para SAIR!");
			System.out.print("Ou digite novamente o número de processos para ser verificado: ");
			NumProcessos = scanner.nextInt();
		}
	}
}
