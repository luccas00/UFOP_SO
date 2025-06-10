using System;
using System.Threading;

namespace CSharp;

public class BufferLimitado
{
    private object[] buffer;
    private int tam;
    private int inIndex, outIndex, cont;

    /*
        mutex é um semáforo binário que garante acesso exclusivo à seção crítica.
        items é um semáforo que conta o número de itens disponíveis no buffer.
        spaces é um semáforo que conta o número de espaços disponíveis no buffer.
    */

    private readonly SemaphoreSlim mutex = new SemaphoreSlim(1, 1);
    private readonly SemaphoreSlim items = new SemaphoreSlim(0, int.MaxValue);
    private readonly SemaphoreSlim spaces;

    public BufferLimitado(int tam)
    {
        this.tam = tam;
        buffer = new object[tam];
        inIndex = outIndex = cont = 0;
        spaces = new SemaphoreSlim(tam, tam);
    }

    public void Insere(object item)
    {
        while (cont == tam) ;

        buffer[inIndex] = item;
        inIndex = (inIndex + 1) % tam;
        cont++;
    }

    public object Retira()
    {
        while (cont == 0) ;

        object item = buffer[outIndex];
        outIndex = (outIndex + 1) % tam;
        cont--;
        return item;
    }

    public void Insere2(object item)
    {
        spaces.Wait(); // Decrementa o número de espaços disponíveis
        mutex.Wait();  // Entra na seção crítica

        buffer[inIndex] = item;
        inIndex = (inIndex + 1) % tam;
        cont++;

        mutex.Release();  // Sai da seção crítica
        items.Release();  // Incrementa o número de itens disponíveis
    }

    public object Retira2()
    {
        items.Wait(); // Decrementa o número de itens disponíveis
        mutex.Wait(); // Entra na seção crítica

        object item = buffer[outIndex];
        outIndex = (outIndex + 1) % tam;
        cont--;

        mutex.Release(); // Sai da seção crítica
        spaces.Release(); // Incrementa o número de espaços disponíveis
        return item;
    }
}

// // Cria um SemaphoreSlim com 1 entrada inicial e 1 entrada máxima (semáforo binário)
// SemaphoreSlim mutex = new SemaphoreSlim(1, 1);

// // Cria um SemaphoreSlim com 0 entradas iniciais e int.MaxValue entradas máximas
// SemaphoreSlim items = new SemaphoreSlim(0, int.MaxValue);

// // Cria um SemaphoreSlim com tam entradas iniciais e tam entradas máximas
// int tam = 10;
// SemaphoreSlim spaces = new SemaphoreSlim(tam, tam);


// // Cria um semáforo com 1 entrada inicial e 1 entrada máxima (semáforo binário)
// Semaphore semaphore = new Semaphore(1, 1);

// // Adquire o semáforo
// semaphore.WaitOne();

// // Libera o semáforo
// semaphore.Release();


// // Cria um SemaphoreSlim com 1 entrada inicial e 1 entrada máxima (semáforo binário)
// SemaphoreSlim semaphoreSlim = new SemaphoreSlim(1, 1);

// // Adquire o semáforo
// semaphoreSlim.Wait();

// // Libera o semáforo
// semaphoreSlim.Release();