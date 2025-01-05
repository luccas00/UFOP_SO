#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> //biblioteca para fork e exec
#include <sys/wait.h> // biblioteca para waitpid

int main(int argc, char const *argv[]) {
	pid_t pidFilho = fork();

	if(pidFilho < 0) {
		printf("Erro na criação do processo!\n");
		return -1;
	} else if(pidFilho == 0) {//processo filho executará o que está aqui dentro
		//execl so retorna um valor se algum erro ocorrer!
		//substituir "/usr/bin" pelo diretorio onde o chrome esta instalado
		int ret = execl("/usr/bin/google-chrome", "chrome", "www.ufop.br", NULL);

		printf("Erro: Impossivel executar execl\n");
		printf("Valor de retorno: %d\n", ret);
		return ret;
	} else {//processo pai executará o que está aqui dentro
		pid_t pidPai = getpid();

		printf("PID do processo Pai %d\n", pidPai);
		printf("PID do processo filho %d\n", pidFilho);

		int status;

		//aguardando o processo filho:
		waitpid(pidFilho, &status, 0);
		printf("Processo %d finalizou com status %d\n", pidFilho, status);

		//alternativa ao waitpid: (descomentar linhas 33 e 34 e comentar linhas 29 e 30)
		//pid_t terminou = wait(&status);
		//printf("Processo %d finalizou com status %d\n", terminou, status);
		
		printf("Processo pai está finalizando...\n");
	}

	return 0;
}