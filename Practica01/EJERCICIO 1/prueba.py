from cronometro import Cronometro

# Ordenacion por seleccion
def ordenar(lista):
    n = len(lista)
    for i in range(n - 1):
        menor = i
        for j in range(i + 1, n):
            if lista[j] < lista[menor]:
                menor = j
        temp = lista[menor]
        lista[menor] = lista[i]
        lista[i] = temp


n = 100000
numeros = []
for i in range(n):
    numeros.append(n - i)   # llena de forma descendente

cronometro = Cronometro()

cronometro.inicia()
ordenar(numeros)
cronometro.detener()

print("Tiempo:", cronometro.lapso_de_tiempo(), "milisegundos")