from Estadistica import Estadistica

print("ESTADISTICA: PROMEDIO Y DESVIACION ESTANDAR")

datos = []
for i in range(10):
    numero = float(input(f"INGRESE EL VALOR {i+1}: "))
    datos.append(numero)

est = Estadistica(datos)
print(f"PROMEDIO: {est.promedio():.5f}")
print(f"DESVIACION: {est.desviacion():.5f}")