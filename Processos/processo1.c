#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h> //biblioteca para fork e exec

int globalVar = 5;

int main() {

    char identificador[256];

    int localVar = 20;

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
		//printf("PID do processo pai %d\n", pidPai);

        printf("PID do processo pai %d\n", pidPai);
        printf("PID do processo filho %d\n", pid);


		strcpy(identificador, "Filho");
        localVar = localVar * globalVar;
		globalVar = globalVar * 2;

        sleep(30);

	} else { //processo pai executará o que está aqui dentro
		sleep(3); //experimente colocar o sleep em locais diferentes
        printf("Ola, sou o processo pai\n");
		//printf("PID do processo filho %d\n", pid);
		printf("PID do processo pai %d\n", getpid());

        printf("PID do processo pai %d\n", pidPai);
        printf("PID do processo filho %d\n", pid);

        strcpy(identificador, "Pai");
        localVar = localVar / globalVar;
		globalVar = globalVar / 5;

        sleep(30);
        
	}


	//Exercício: quais os valores que serão exibidos na tela a seguir, considerando
	//cada um dos processos?
	printf("GlobalVar(%s) = %d\n", identificador, globalVar);
	printf("LocalVar(%s) = %d\n", identificador, localVar);
	printf("teste print\n"); //ambos os processos executarão essa instrução

	return 0;
}