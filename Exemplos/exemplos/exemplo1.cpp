#include <stdio.h>
#include <string.h>
#include <unistd.h> //syscalls

/*Exemplo 1: imprimindo uma mensagem na tela.
 * O codigo a seguir tem o mesmo efeito de:
 * printf("Ola mundo!\n");
 */

int main(int argc, char const *argv[]) {
	write(STDOUT_FILENO, "Ola mundo!\n", strlen("Ola mundo!\n")); //STDOUT_FILENO = SAIDA PADRAO

	return 0;
}