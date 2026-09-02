import math

#FUNCIONES
def promedio(datos):
    suma = 0
    for i in range(10):
        suma = suma + datos[i]
    return suma / 10


def desviacion(datos):
    suma = 0
    for i in range(10):
        suma = math.pow(datos[i] - promedio(datos), 2) + suma
    return math.sqrt(suma / 9)


# MAIN
print("ESTADISTICA: PROMEDIO Y DESVIACION ESTANDAR")

datos = []
for i in range(10):
    numero = float(input(f"INGRESE EL VALOR {i+1}: "))
    datos.append(numero)

print(f"PROMEDIO: {promedio(datos):.5f}")
print(f"DESVIACION: {desviacion(datos):.5f}")