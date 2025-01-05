#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h> //syscalls

/*Exemplo 2: lendo uma string do teclado e exibindo na tela.
 * O codigo a seguir tem o mesmo efeito de:
 * size_t size = 256;
 * char *msg = (char*) malloc (sizeof(char) * size);
 * printf("Digite uma mensagem: ");
 * getline(&msg, &size, stdin);
 * printf("Voce digitou: %s", msg);
 * free(msg);
 */

int main(int argc, char const *argv[]) {
	size_t size = 256;
	char *msg = (char*) malloc (sizeof(char) * size);

	write(STDOUT_FILENO, "Digite uma mensagem: ", strlen("Digite uma mensagem: "));
	read(STDIN_FILENO, msg, size); //STDIN_FILENO = ENTRADA PADRAO
	write(STDOUT_FILENO, "Voce digitou: ", strlen("Voce digitou: "));
	write(STDOUT_FILENO, msg, strlen(msg));
	
	free(msg);

	return 0;
}