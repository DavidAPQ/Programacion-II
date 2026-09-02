from EcuacionLineal import EcuacionLineal

print("ECUACION LINEAL: ax + by = e, cx + dy = f")

a = int(input("INGRESE a: "))
b = int(input("INGRESE b: "))
c = int(input("INGRESE c: "))
d = int(input("INGRESE d: "))
e = int(input("INGRESE e: "))
f = int(input("INGRESE f: "))

ecuacion1 = EcuacionLineal(a, b, c, d, e, f)

if (ecuacion1.tieneSolucion()):
    print(f"X = {ecuacion1.getX()}")
    print(f"Y = {ecuacion1.getY()}")
else:
    print("La ecuacion no tiene solucion")