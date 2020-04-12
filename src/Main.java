import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		List<Processo> processos = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira a quantidade de processos que deseja verificar: ");
		int contador = sc.nextInt();
		
		for (int i = 1; i <= contador; i++) {
			sc.nextLine();
			System.out.println();
			System.out.print("Identificador do processo " + i + ": ");
			String id = sc.nextLine();
			
			System.out.print("Prioridade: ");
			int prioridade = sc.nextInt();
			
			System.out.print("Tempo de execução: ");
			int tempoDeExecucao = sc.nextInt();
			
			System.out.print("Tamanho: ");
			int tamanho = sc.nextInt();
			
			processos.add(new Processo(id, prioridade, tempoDeExecucao, tamanho));
		}
		
		Collections.sort(processos);
		
		while(processos.size() > 0) {
			System.out.println(processos.get(0).toString());
			
			int tempo = processos.get(0).getTempoDeExecucao();
			
			while(processos.get(0).getTamanho() > 0) {
				if(tempo == 0) {
					processos.get(0).setTamanho(processos.get(0).getTamanho() - 1);
					System.out.println(processos.get(0).toString());
				} else {
					tempo--;
				}
				Thread.sleep(1000);
			}
			
			if(processos.get(0).getTamanho() <= 0) {
				processos.remove(0);
				System.out.println("Processo finalizado");
			}
			Thread.sleep(1000);
		}
		
		sc.close();
	}
	
}