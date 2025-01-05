#include <cstdio>
#include <cstdlib>
#include <unistd.h> //biblioteca para fork e exec

int main(int argc, char const *argv[]) {
	pid_t pid;

	pid_t pidPai = getpid();

	pid = fork();//fork() cria um processo filho e retorna o identificador deste processo.
				 //o processo pai "enxerga" o identificador do processo filho que acabou
				 //de ser gerado (um valor inteiro > 0). O processo filho "enxerga" esse
				 //identificador como zero.

	if(pid < 0) {
		printf("Erro na criação do processo!\n");
		return -1;
	} else if(pid == 0) { //processo filho executará o que está aqui dentro
		printf("Ola, sou o processo filho\n");
		printf("PID do processo filho %d\n", getpid());
		printf("PID do processo pai %d\n", pidPai);
	} else { //processo pai executará o que está aqui dentro
		printf("Ola, sou o processo pai\n");
		//sleep(3); //experimente colocar o sleep em locais diferentes
		printf("PID do processo filho %d\n", pid);
		printf("PID do processo pai %d\n", getpid());
	}

	printf("teste print\n"); //ambos os processos executarão essa instrução

	return 0;
}