package controller;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{
	private int nPessoa;
	private Semaphore semaforo;
	
	public Pessoa(int nPessoa, Semaphore semaforo) {
		this.nPessoa = nPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Caminhando();
		try {
			semaforo.acquire();
			atravessandoPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void atravessandoPorta() {
		System.out.println("Pessoa " + nPessoa + " está atravessando a porta");
		
		int tempo = 1 + (int)(Math.random() * (2 - 1));
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Pessoa " + nPessoa + " está atravessou a porta");
		
	}

	private void Caminhando() {
		int distancia = 0;
		int velocidade = 4 + (int)(Math.random() * (6 - 4));
		
		System.out.println("Pessoa " + nPessoa + " está caminhando");
		
		while(distancia < 200) {
			distancia += velocidade;
		}
		
		System.out.println("Pessoa " + nPessoa + " chegou na porta");
		
	}
	
}
