package view;

import java.util.concurrent.Semaphore;

import controller.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int nPessoa = 1; nPessoa <= 4; nPessoa ++) {
			Thread pessoa = new Pessoa(nPessoa, semaforo);
			pessoa.start();
		}

	}

}
