#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //biblioteca para fork

int globalVar = 5;

int main(int argc, char const *argv[]) {
	char identificador[256];

	int localVar = 20;

	pid_t pid = fork();

	if(pid < 0) {
		printf("Erro na criação do processo!\n");
		return -1;
	} else if(pid == 0) {//processo filho executará o que está aqui dentro
		printf("Ola, sou o processo filho\n");
		//sleep(3); //experimente colocar o sleep em locais diferentes
		sprintf(identificador, "Filho");
		localVar = localVar * globalVar;
		globalVar = globalVar * 2;
	} else {//processo pai executará o que está aqui dentro
		printf("Ola, sou o processo pai\n");
		sprintf(identificador, "Pai");
		localVar = localVar / globalVar;
		globalVar = globalVar / 5;
	}

	//Exercício: quais os valores que serão exibidos na tela a seguir, considerando
	//cada um dos processos?
	printf("GlobalVar(%s) = %d\n", identificador, globalVar);
	printf("LocalVar(%s) = %d\n", identificador, localVar);

	return 0;
}