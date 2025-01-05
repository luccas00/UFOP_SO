#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h> //syscalls
#include <fcntl.h> //forma de acesso ao arquivo

/*Exemplo 3: abrindo e escrevendo em um arquivo
 * O codigo a seguir tem o mesmo efeito de:
 * FILE* arquivo = fopen("arquivo.txt", "a");
 * if(!arquivo) {
 * 	printf("Nao foi possivel abrir o arquivo!\n");
 * 	return 1;
 * }
 * char msg[] = "Ola mundo!\n";
 * fprintf(arquivo, "%s", msg);
 * fclose(arquivo);
 */

int main(int argc, char const *argv[]) {
	int fd = open("arquivo.txt", O_APPEND | O_CREAT | O_RDWR, S_IRWXU);
	
	if(!fd) {
		char err[] = "Nao foi possivel abrir o arquivo!\n";
		write(STDOUT_FILENO, err, strlen(err));
		return 1;
	}

	write(fd, "Ola mundo!\n", strlen("Ola mundo!\n"));
	close(fd);

	return 0;
}